package kz.intertop.service;

import kz.intertop.dto.SubTypeDto;
import kz.intertop.mapper.SubTypeMapper;
import kz.intertop.models.item.SubType;
import kz.intertop.repository.SubTypeRepository;
import kz.intertop.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubTypeService {
    private final SubTypeRepository subTypeRepository;
    private final SubTypeMapper subTypeMapper;
    private final UserService userService;
    private final TypeRepository typeRepository;
    private Map<Long, SubTypeDto> subTypesDtoMap;
    private Map<Long, SubType> subTypesMap;

    @PostConstruct
    public void initSubTypeMaps() {
        List<SubType> allSubTypes = subTypeRepository.findAllByOrderByType();
        subTypesDtoMap = allSubTypes.stream().map(subTypeMapper::toDto).collect(Collectors.toMap(SubTypeDto::getId, Function.identity()));
        subTypesMap = allSubTypes.stream().collect(Collectors.toMap(SubType::getId, Function.identity()));
    }

    private SubType assignType(SubTypeDto subTypeDto) {
        SubType subType = subTypeMapper.toEntity(subTypeDto);
        subType.setType(typeRepository.findTypeById(subTypeDto.getType().getId()));
        return subType;
    }

    public SubTypeDto create(SubTypeDto subTypeDto) {
        if (!userService.isModer() || subTypeRepository.findSubTypeByName(subTypeDto.getName()) != null) {
            return null;
        }
        SubType subType = assignType(subTypeDto);
        return subTypeMapper.toDto(subTypeRepository.save(subType));
    }

    public SubTypeDto getByIdDto(Long id) {
        return subTypesDtoMap.get(id);
    }

    public SubType getById(Long id) {
        return subTypesMap.get(id);
    }

    public List<SubTypeDto> getByTypeId(Long id) {
        return subTypeRepository.findSubTypesByTypeId(id).stream().map(subTypeMapper::toDto).toList();
    }

    public SubTypeDto update(SubTypeDto subTypeDto) {
        if (!userService.isModer() || !subTypeRepository.existsById(subTypeDto.getId())) {
            return null;
        }
        SubType subType = subTypeRepository.findSubTypeById(subTypeDto.getId());
        subType.setName(subTypeDto.getName());
        subType.setType(typeRepository.findTypeById(subTypeDto.getType().getId()));
        return subTypeMapper.toDto(subTypeRepository.save(subType));
    }

    public void deleteById(Long id) {
        subTypeRepository.deleteById(id);
    }

    public List<SubTypeDto> getAllDto() {
        return subTypeRepository.findAllByOrderByType().stream().map(subTypeMapper::toDto).collect(Collectors.toList());
    }
}
