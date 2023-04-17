package kz.RealIntertop.models.item;

import javax.persistence.*;

import kz.RealIntertop.models.BaseEntity;
import lombok.*;

import java.util.List;
import java.util.Objects;
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
    @ManyToOne
    private Brand brand;
    private boolean child;
    private String article;
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    private Type type;
    @ManyToOne
    @JoinColumn(name = "sub_type_id")
    private SubType subType;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Material> materials;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Color> colors;
    @ManyToOne
    private Gender gender;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Picture> pictures;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId() == item.getId() && Objects.equals(modelName, item.getModelName());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getId(), modelName);
    }
}
