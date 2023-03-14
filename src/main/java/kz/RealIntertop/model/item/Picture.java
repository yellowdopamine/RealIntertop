package kz.RealIntertop.model.item;

import kz.RealIntertop.model.BaseEntity;
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
