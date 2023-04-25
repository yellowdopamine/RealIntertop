package kz.intertop.mapper;

import kz.intertop.dto.ColorDto;
import kz.intertop.models.item.Color;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ColorMapper {
    Color toEntity(ColorDto colorDto);
    ColorDto toDto(Color color);
}
