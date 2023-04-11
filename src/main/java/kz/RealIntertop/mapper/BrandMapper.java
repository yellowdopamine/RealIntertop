package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.BrandDto;
import kz.RealIntertop.models.item.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    Brand toEntity(BrandDto brandDto);
    BrandDto toDto(Brand brand);
}
