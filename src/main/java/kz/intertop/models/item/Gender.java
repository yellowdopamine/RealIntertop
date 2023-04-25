package kz.intertop.models.item;

import kz.intertop.models.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Gender extends BaseEntity {
    private String name;
}
