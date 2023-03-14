package kz.RealIntertop.model.item;

import kz.RealIntertop.model.BaseEntity;
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
