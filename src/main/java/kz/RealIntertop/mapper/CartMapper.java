package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.CartDto;
import kz.RealIntertop.models.item.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDto toDto (Cart cart);
    Cart toEntity(CartDto cartDto);
}
