package kz.intertop.mapper;

import kz.intertop.dto.BrandDto;
import kz.intertop.models.item.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    Brand toEntity(BrandDto brandDto);
    BrandDto toDto(Brand brand);
}
