package kz.RealIntertop.models.item;

import kz.RealIntertop.models.BaseEntity;
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
