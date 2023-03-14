package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.ManufacturerDto;
import kz.RealIntertop.model.item.Manufacturer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {
    Manufacturer toEntity(ManufacturerDto manufacturerDto);
    ManufacturerDto toDto(Manufacturer manufacturer);
}
