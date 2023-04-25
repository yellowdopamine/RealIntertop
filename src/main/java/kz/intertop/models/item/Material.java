package kz.intertop.models.item;

import javax.persistence.Entity;
import kz.intertop.models.BaseEntity;
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
