package kz.intertop.models.item;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import kz.intertop.models.BaseEntity;
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
