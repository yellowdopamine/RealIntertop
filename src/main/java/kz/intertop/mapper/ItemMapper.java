package kz.intertop.mapper;

import kz.intertop.dto.ItemDto;
import kz.intertop.models.item.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item toEntity(ItemDto itemDto);
    ItemDto toDto(Item item);
}
