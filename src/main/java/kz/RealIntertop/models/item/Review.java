package kz.RealIntertop.models.item;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import kz.RealIntertop.models.BaseEntity;
import kz.RealIntertop.models.user.User;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review extends BaseEntity {
    private int rating;
    private String content;
    @ManyToOne
    private User user;
}
