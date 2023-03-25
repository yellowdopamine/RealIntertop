package kz.RealIntertop.service;

import kz.RealIntertop.dto.TypeDto;
import kz.RealIntertop.mapper.TypeMapper;
import kz.RealIntertop.model.item.Type;
import kz.RealIntertop.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TypeService {
    private final UserService userService;
    private final TypeRepository typeRepository;
    private final TypeMapper typeMapper;

    public List<TypeDto> getAllDto() {
        return typeRepository.findAll().stream().map(typeMapper::toDto).collect(Collectors.toList());
    }

    public List<Type> getAll() {
        return typeRepository.findAll();
    }

    public TypeDto getById(Long id) {
        return typeMapper.toDto(typeRepository.findTypeById(id));
    }

    public TypeDto create(TypeDto typeDto) {
        if (typeRepository.findTypeByName(typeDto.getName()) != null || !userService.isModer()) {
            return null;
        }
        return typeMapper.toDto(typeRepository.save(typeMapper.toEntity(typeDto)));

    }

    public TypeDto update(TypeDto typeDto) {
        Type type = typeRepository.findTypeById(typeDto.getId());
        if (type == null || !userService.isModer()) {
            return null;
        }
        type.setName(typeDto.getName());
        return typeMapper.toDto(typeRepository.save(type));
    }

    public void deleteById(Long id) {
            if (userService.isModer()) {
                typeRepository.deleteById(id);
            }
    }
}
