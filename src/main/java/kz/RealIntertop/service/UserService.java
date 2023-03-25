package kz.RealIntertop.service;

import kz.RealIntertop.model.user.Authority;
import kz.RealIntertop.model.user.User;
import kz.RealIntertop.repository.AuthorityRepository;
import kz.RealIntertop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user != null){
            return user;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            return (User) authentication.getPrincipal();
        } return null;
    }
    public boolean isModer(){
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            return false;
        }
        Authority moderAuthority = authorityRepository.findAuthorityByAuthorityLike("ROLE_MODER");
        if (moderAuthority == null) {
            return false;
        }
        List<String> userAuthorities = currentUser.getAuthorities().stream().map(Authority::getAuthority).toList();
        boolean hasModerAuthority = userAuthorities.contains(moderAuthority.getAuthority());
        if (!hasModerAuthority) {
            System.out.println("User " + currentUser.getUsername() + " does not have ROLE_MODER authority.");
        }
        return hasModerAuthority;
    }
}
