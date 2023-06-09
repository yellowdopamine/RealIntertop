package kz.intertop.models.item;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import kz.intertop.models.BaseEntity;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Collection extends BaseEntity {
    private String name;
    @ManyToOne
    private Season season;
    @ManyToOne
    private Brand brand;
    @ManyToOne
    private Manufacturer manufacturer;
    private int year;
}