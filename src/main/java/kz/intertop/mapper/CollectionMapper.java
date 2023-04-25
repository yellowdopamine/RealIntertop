package kz.intertop.mapper;

import kz.intertop.dto.CollectionDto;
import kz.intertop.models.item.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {BrandMapper.class, SeasonMapper.class})
public interface CollectionMapper {
    Collection toEntity(CollectionDto collectionDto);
    CollectionDto toDto(Collection collection);
}
