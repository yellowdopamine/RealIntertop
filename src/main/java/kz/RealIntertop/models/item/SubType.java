package kz.RealIntertop.models.item;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import kz.RealIntertop.models.BaseEntity;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SubType extends BaseEntity {
    private String name;
    @ManyToOne
    private Type type;
}
