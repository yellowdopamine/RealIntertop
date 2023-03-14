package kz.RealIntertop.model.user.address;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import kz.RealIntertop.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Building extends BaseEntity {
    private int buildingCode;
    private int number;
    @ManyToOne
    private Street street;
}
