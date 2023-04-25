package kz.intertop.models.item;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import kz.intertop.models.BaseEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Type extends BaseEntity {
    private String name;
    @OneToMany
    private List<SubType> subTypes;
}
