package kz.RealIntertop.service;

import kz.RealIntertop.dto.SubTypeDto;
import kz.RealIntertop.mapper.SubTypeMapper;
import kz.RealIntertop.models.item.SubType;
import kz.RealIntertop.repository.SubTypeRepository;
import kz.RealIntertop.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubTypeService {
    private final SubTypeRepository subTypeRepository;
    private final SubTypeMapper subTypeMapper;
    private final UserService userService;
    private final TypeRepository typeRepository;
    private SubType assignType(SubTypeDto subTypeDto){
        SubType subType = subTypeMapper.toEntity(subTypeDto);
        subType.setType(typeRepository.findTypeById(subTypeDto.getType().getId()));
        return subType;
    }
    public SubTypeDto create(SubTypeDto subTypeDto){
        if(!userService.isModer() || subTypeRepository.findSubTypeByName(subTypeDto.getName()) != null){
            return null;
        }
        SubType subType = assignType(subTypeDto);
        return subTypeMapper.toDto(subTypeRepository.save(subType));
    }
    public SubTypeDto getById(Long id) {
        return subTypeMapper.toDto(subTypeRepository.findSubTypeById(id));
    }
    public List<SubTypeDto> getByTypeId(Long id) {
        return subTypeRepository.findSubTypesByTypeId(id).stream().map(subTypeMapper::toDto).collect(Collectors.toList());
    }
    public SubTypeDto update(SubTypeDto subTypeDto){
        if(!userService.isModer() || !subTypeRepository.existsById(subTypeDto.getId())){
            return null;
        }
        SubType subType = subTypeRepository.findSubTypeById(subTypeDto.getId());
        subType.setName(subTypeDto.getName());
        subType.setType(typeRepository.findTypeById(subTypeDto.getType().getId()));
        return subTypeMapper.toDto(subTypeRepository.save(subType));
    }
    public void deleteById(Long id){
        subTypeRepository.deleteById(id);
    }
    public List<SubTypeDto> getAll() {
        return subTypeRepository.findAllByOrderByType().stream().map(subTypeMapper::toDto).collect(Collectors.toList());
    }
}
