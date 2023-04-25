package kz.intertop.models.item;

import javax.persistence.Entity;
import kz.intertop.models.BaseEntity;
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
