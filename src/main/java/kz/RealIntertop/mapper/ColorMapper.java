package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.ColorDto;
import kz.RealIntertop.dto.MaterialDto;
import kz.RealIntertop.model.item.Color;
import kz.RealIntertop.model.item.Material;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ColorMapper {
    Color toEntity(ColorDto colorDto);
    ColorDto toDto(Color color);
}
