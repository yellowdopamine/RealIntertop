package kz.RealIntertop.model.user;

import kz.RealIntertop.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Authority extends BaseEntity implements GrantedAuthority{
    private String authority;
}
