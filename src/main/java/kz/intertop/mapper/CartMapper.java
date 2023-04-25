package kz.intertop.mapper;

import kz.intertop.dto.CartDto;
import kz.intertop.models.item.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDto toDto (Cart cart);
    Cart toEntity(CartDto cartDto);
}
