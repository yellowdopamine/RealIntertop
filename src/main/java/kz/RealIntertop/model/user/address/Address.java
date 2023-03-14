package kz.RealIntertop.model.user.address;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import kz.RealIntertop.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address extends BaseEntity {
    @ManyToOne
    private Building building;
    private int entrance;
    private int floor;
    private int flat;
    private String comment;
}
