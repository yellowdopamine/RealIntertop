package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.ItemDto;
import kz.RealIntertop.models.item.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(source = "child", target = "isChild")
    Item toEntity(ItemDto itemDto);
    @Mapping(source = "child", target = "isChild")
    ItemDto toDto(Item item);
}
