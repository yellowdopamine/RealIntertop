package kz.intertop.dto;

import kz.intertop.models.BaseEntity;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CollectionDto extends BaseEntity {
    private Long id;
    private String name;
    private SeasonDto season;
    private BrandDto brand;
    private ManufacturerDto manufacturer;
    private int year;
}
