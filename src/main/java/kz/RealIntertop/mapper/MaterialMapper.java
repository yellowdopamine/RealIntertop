package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.MaterialDto;
import kz.RealIntertop.models.item.Material;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialMapper {
    Material toEntity(MaterialDto materialDto);
    MaterialDto toDto(Material material);
}
