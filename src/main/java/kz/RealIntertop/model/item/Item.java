package kz.RealIntertop.model.item;

import javax.persistence.*;

import kz.RealIntertop.model.BaseEntity;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item extends BaseEntity {
    private String modelName;
    private int discount;
    private double price;
    @ManyToOne
    private Collection collection;
    private short genderId; // 1 - Man, 2 - Woman, 3 - Unisex
    private boolean isChild;
    @ManyToOne
    private SubType subType;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Material> materials;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Color> colors;
//    @ManyToMany(fetch = FetchType.LAZY)
//    private List<Review> reviews;
//    @ManyToMany(fetch = FetchType.LAZY)
//    private List<Size> sizes;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Picture> pictures;

}
