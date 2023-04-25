package kz.intertop.service;

import kz.intertop.dto.TypeDto;
import kz.intertop.mapper.TypeMapper;
import kz.intertop.models.item.Type;
import kz.intertop.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TypeService {
    private final UserService userService;
    private final TypeRepository typeRepository;
    private final TypeMapper typeMapper;
    private Map<Long, TypeDto> typesDtoMap;
    private Map<Long, Type> typesMap;

    @PostConstruct
    public void initTypeMaps() {
        List<Type> allTypes = getAll();
        typesDtoMap = allTypes.stream().map(typeMapper::toDto).collect(Collectors.toMap(TypeDto::getId, Function.identity()));
        typesMap = allTypes.stream().collect(Collectors.toMap(Type::getId, Function.identity()));
    }

    public List<TypeDto> getAllDto() {
        return typeRepository.findAll().stream().map(typeMapper::toDto).toList();
    }

    public List<Type> getAll() {
        return typeRepository.findAll();
    }
    public List<Type> getAllByIdIn(List<Long> typeIds) {
        return typeIds.stream().map(typesMap::get).filter(Objects::nonNull).toList();
    }

    public TypeDto getByIdDto(Long id) {
        return typesDtoMap.get(id);
    }
    public Type getById(Long id){
        return typesMap.get(id);
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
