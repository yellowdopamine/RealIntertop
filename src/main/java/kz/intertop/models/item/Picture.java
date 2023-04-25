package kz.intertop.models.item;

import kz.intertop.models.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Picture extends BaseEntity {
    private String name;
}
