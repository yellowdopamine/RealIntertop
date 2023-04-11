package kz.RealIntertop.models.item;

import javax.persistence.Entity;
import kz.RealIntertop.models.BaseEntity;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Material extends BaseEntity {
    private String name;
}
