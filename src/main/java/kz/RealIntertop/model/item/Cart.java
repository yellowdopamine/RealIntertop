package kz.RealIntertop.model.item;
import kz.RealIntertop.model.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cart extends BaseEntity {
    @ManyToMany
    private Set<Item> items;
}
