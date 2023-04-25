package kz.intertop.models.user.address;

import javax.persistence.Entity;

import kz.intertop.models.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class City extends BaseEntity {
    private String name;
    private int cityCode;
}
