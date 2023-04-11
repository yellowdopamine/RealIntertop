package kz.RealIntertop.models.user.address;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import kz.RealIntertop.models.BaseEntity;
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
