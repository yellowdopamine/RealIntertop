package kz.RealIntertop.model.item;

import javax.persistence.Entity;
import kz.RealIntertop.model.BaseEntity;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer extends BaseEntity {
    private String name;
}
