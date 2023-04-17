package kz.RealIntertop.models.item;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import kz.RealIntertop.models.BaseEntity;
import lombok.*;

import java.util.List;

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