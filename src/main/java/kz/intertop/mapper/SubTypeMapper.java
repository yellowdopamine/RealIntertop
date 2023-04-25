package kz.intertop.mapper;

import kz.intertop.dto.SubTypeDto;
import kz.intertop.models.item.SubType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubTypeMapper {
    SubType toEntity(SubTypeDto subTypeDto);
    SubTypeDto toDto(SubType subType);
}
