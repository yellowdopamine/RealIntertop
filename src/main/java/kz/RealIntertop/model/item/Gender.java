package kz.RealIntertop.model.item;

import kz.RealIntertop.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Gender extends BaseEntity {
    private String name;
}
