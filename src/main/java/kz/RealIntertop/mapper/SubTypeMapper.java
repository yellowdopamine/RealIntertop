package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.SubTypeDto;
import kz.RealIntertop.models.item.SubType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubTypeMapper {
    SubType toEntity(SubTypeDto subTypeDto);
    SubTypeDto toDto(SubType subType);
}
