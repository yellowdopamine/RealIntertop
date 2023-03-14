package kz.RealIntertop.model.user.address;

import javax.persistence.Entity;

import kz.RealIntertop.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class City extends BaseEntity {
    private String name;
    private int cityCode;
}
