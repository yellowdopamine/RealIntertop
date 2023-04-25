package kz.intertop.models.item;

import kz.intertop.models.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Season extends BaseEntity {
    private String name;
}
