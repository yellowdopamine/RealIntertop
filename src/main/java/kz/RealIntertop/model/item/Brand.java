package kz.RealIntertop.model.item;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import kz.RealIntertop.model.BaseEntity;
import lombok.*;
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Brand extends BaseEntity {
    private String name;
    @OneToOne
    private Picture picture;
}
