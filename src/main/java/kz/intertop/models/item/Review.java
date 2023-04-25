package kz.intertop.models.item;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import kz.intertop.models.BaseEntity;
import kz.intertop.models.user.User;
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
