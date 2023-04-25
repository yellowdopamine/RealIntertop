package kz.intertop.models.item;
import kz.intertop.models.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cart extends BaseEntity {
    // todo Реализовать Cart
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Item> items;
}
