package kz.intertop.dto;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDto {
    private Long id;
    private String modelName;
    private int discount;
    private double price;
    private CollectionDto collection;
    private BrandDto brand;
    private GenderDto gender;
    private boolean child;
    private String article;
    private String content;
    private SubTypeDto subType;
    private TypeDto type;
    private List<MaterialDto> materials;
    private List<ColorDto> colors;
    private Set<PictureDto> pictures;
}
