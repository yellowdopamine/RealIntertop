package kz.RealIntertop.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemRequest {
    private Long id;
    private String modelName;
    private int discount;
    private double price;
    private CollectionDto collection;
    private short genderId; // 1 - Man, 2 - Woman, 3 - Unisex
    private SubTypeDto subType;
    private Set<MaterialDto> materials;
    private Set<ColorDto> colors;
    private List<MultipartFile> images;

//    private List<Picture> pictures;
}
