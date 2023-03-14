package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.SubTypeDto;
import kz.RealIntertop.dto.TypeDto;
import kz.RealIntertop.model.item.SubType;
import kz.RealIntertop.model.item.Type;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubTypeMapper {
    SubType toEntity(SubTypeDto subTypeDto);
    SubTypeDto toDto(SubType subType);
}
