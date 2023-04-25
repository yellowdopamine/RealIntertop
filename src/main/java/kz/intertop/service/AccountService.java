package kz.intertop.service;

import kz.intertop.dto.UserDto;
import kz.intertop.mapper.UserMapper;
import kz.intertop.models.item.Cart;
import kz.intertop.models.user.Authority;
import kz.intertop.models.user.User;
import kz.intertop.repository.AuthorityRepository;
import kz.intertop.repository.CartRepository;
import kz.intertop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;
    private final UserService userService;
    private final UserMapper userMapper;

    public UserDto getUserById(Long id) {
        User currentUser = userService.getCurrentUser();
        if (Objects.equals(currentUser.getId(), id) ||
                currentUser.getAuthorities().contains(authorityRepository.findAuthorityByAuthorityLike("ROLE_ADMIN"))) {
            return userMapper.toDto(userRepository.getUserById(id));
        }
        return null;
    }

    public UserDto createUser(UserDto userDto) {
        if (!userRepository.existsUserByEmail(userDto.getEmail())) {
            Cart cart = Cart.builder().build();
            List<Authority> authorities = new ArrayList<>();
            authorities.add(authorityRepository.findAuthorityByAuthorityLike("ROLE_USER"));
            User user = userMapper.toEntity(userDto);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setNonLocked(true);
            user.setAuthorities(authorities);
            user.setCart(cartRepository.save(cart));

            return userMapper.toDto(userRepository.save(user));
        }
        return null;
    }

    public UserDto updateUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        if (Objects.equals(userService.getCurrentUser().getId(), user.getId())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userMapper.toDto(userRepository.save(user));
        }
        return null;
    }

    public boolean deleteUserById(Long id) {
        User currentUser = userService.getCurrentUser();
        if (Objects.equals(currentUser.getId(), id) ||
                currentUser.getAuthorities().contains(
                        authorityRepository.findAuthorityByAuthorityLike("ROLE_ADMIN"))) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}