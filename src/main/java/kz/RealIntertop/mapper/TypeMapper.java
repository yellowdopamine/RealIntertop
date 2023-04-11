package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.TypeDto;
import kz.RealIntertop.models.item.Type;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper {
    Type toEntity(TypeDto typeDto);
    TypeDto toDto(Type type);
}
