package kz.intertop.models.item;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import kz.intertop.models.BaseEntity;
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
