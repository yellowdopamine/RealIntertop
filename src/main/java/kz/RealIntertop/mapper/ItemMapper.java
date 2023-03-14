package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.ItemDto;
import kz.RealIntertop.model.item.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item toEntity(ItemDto itemDto);
    ItemDto toDto(Item item);
}
