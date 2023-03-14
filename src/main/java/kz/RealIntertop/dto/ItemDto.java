package kz.RealIntertop.dto;

import kz.RealIntertop.model.item.Picture;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

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
    private short genderId; // 1 - Man, 2 - Woman, 3 - Unisex
    private boolean isChild;
    private SubTypeDto subType;
    private Set<MaterialDto> materials;
    private Set<ColorDto> colors;
    private Set<PictureDto> pictures;
    private List<MultipartFile> fileList;
}
