package kz.intertop.mapper;

import kz.intertop.dto.TypeDto;
import kz.intertop.models.item.Type;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper {
    Type toEntity(TypeDto typeDto);
    TypeDto toDto(Type type);
}
