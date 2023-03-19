package kz.RealIntertop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CartDto {
    private Set<ItemDto> items;
}
