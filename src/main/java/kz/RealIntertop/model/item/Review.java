package kz.RealIntertop.model.item;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import kz.RealIntertop.model.BaseEntity;
import kz.RealIntertop.model.user.User;
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
