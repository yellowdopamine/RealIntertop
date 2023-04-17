package kz.RealIntertop.dto;

import kz.RealIntertop.models.BaseEntity;
import kz.RealIntertop.models.item.Item;
import lombok.*;

import java.util.List;


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
