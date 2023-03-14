package kz.RealIntertop.model.item;

import javax.persistence.Entity;
import kz.RealIntertop.model.BaseEntity;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Color extends BaseEntity {
    private String name;
    private String hashCode;
    private int red;
    private int green;
    private int blue;
}
