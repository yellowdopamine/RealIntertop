package kz.intertop.mapper;

import kz.intertop.dto.MaterialDto;
import kz.intertop.models.item.Material;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialMapper {
    Material toEntity(MaterialDto materialDto);
    MaterialDto toDto(Material material);
}
