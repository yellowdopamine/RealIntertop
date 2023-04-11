package kz.RealIntertop.dto;

import kz.RealIntertop.models.user.Authority;
import kz.RealIntertop.models.user.address.Address;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String fullName;
    private Long phoneNumber;
    private String email;
    private String password;
    private boolean nonLocked;
    private Address address;
    private List<Authority> authorities;
    private CartDto cart;
}
