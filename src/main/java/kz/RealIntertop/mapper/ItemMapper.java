package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.ItemDto;
import kz.RealIntertop.models.item.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item toEntity(ItemDto itemDto);
    ItemDto toDto(Item item);
}
