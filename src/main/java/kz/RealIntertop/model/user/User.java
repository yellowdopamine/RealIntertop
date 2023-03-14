package kz.RealIntertop.model.user;

import kz.RealIntertop.model.BaseEntity;
import kz.RealIntertop.model.user.address.Address;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity implements UserDetails{
    private String fullName;
    private Long phoneNumber;
    @Column(updatable = false)
    private String email;
    private String password;
    private boolean nonLocked;
    @ManyToOne
    private Address address;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Authority> authorities;


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
