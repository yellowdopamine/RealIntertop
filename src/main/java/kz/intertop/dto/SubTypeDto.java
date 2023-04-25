package kz.intertop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubTypeDto {
    private Long id;
    private String name;
    private TypeDto type;
}
