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
    private boolean isChild;
    private String article;
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    private SubType subType;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Material> materials;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Color> colors;
    @ManyToOne
    private Gender gender;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Picture> pictures;
}
