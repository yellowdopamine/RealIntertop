package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.CartDto;
import kz.RealIntertop.dto.TypeDto;
import kz.RealIntertop.model.item.Cart;
import kz.RealIntertop.model.item.Type;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDto toDto (Cart cart);
    Cart toEntity(CartDto cartDto);
}
