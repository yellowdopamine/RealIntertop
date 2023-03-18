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
public class ItemDto {
    private Long id;
    private String modelName;
    private int discount;
    private double price;
    private CollectionDto collection;
    private GenderDto gender;
    private boolean isChild;
    private String article;
    private String content;
    private SubTypeDto subType;
    private Set<MaterialDto> materials;
    private Set<ColorDto> colors;
    private Set<PictureDto> pictures;
}
