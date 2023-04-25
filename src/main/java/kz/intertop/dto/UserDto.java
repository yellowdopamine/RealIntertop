package kz.intertop.dto;

import kz.intertop.models.user.Authority;
import kz.intertop.models.user.address.Address;
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
