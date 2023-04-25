package kz.intertop.mapper;

import kz.intertop.dto.ManufacturerDto;
import kz.intertop.models.item.Manufacturer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {
    Manufacturer toEntity(ManufacturerDto manufacturerDto);
    ManufacturerDto toDto(Manufacturer manufacturer);
}
