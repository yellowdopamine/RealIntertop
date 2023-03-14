package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.ManufacturerDto;
import kz.RealIntertop.dto.MaterialDto;
import kz.RealIntertop.model.item.Manufacturer;
import kz.RealIntertop.model.item.Material;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialMapper {
    Material toEntity(MaterialDto materialDto);
    MaterialDto toDto(Material material);
}
