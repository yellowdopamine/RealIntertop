package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.CollectionDto;
import kz.RealIntertop.models.item.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {BrandMapper.class, SeasonMapper.class})
public interface CollectionMapper {
    Collection toEntity(CollectionDto collectionDto);
    CollectionDto toDto(Collection collection);
}
