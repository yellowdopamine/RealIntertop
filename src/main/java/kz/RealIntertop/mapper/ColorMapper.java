package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.ColorDto;
import kz.RealIntertop.models.item.Color;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ColorMapper {
    Color toEntity(ColorDto colorDto);
    ColorDto toDto(Color color);
}
