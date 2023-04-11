package kz.RealIntertop.dto;

import kz.RealIntertop.models.item.Picture;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandDto {
    private Long id;
    private String name;
    private Picture picture;
}
