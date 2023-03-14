package kz.RealIntertop.model.item;

import javax.persistence.Entity;
import kz.RealIntertop.model.BaseEntity;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Size extends BaseEntity {
    private int sizeNumber;
}
