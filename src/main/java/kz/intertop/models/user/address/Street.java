package kz.intertop.models.user.address;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import kz.intertop.models.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Street extends BaseEntity {
    private String name;
    @ManyToOne
    private City city;
}
