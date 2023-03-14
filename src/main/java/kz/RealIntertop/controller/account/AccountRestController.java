package kz.RealIntertop.controller.account;

import kz.RealIntertop.dto.UserDto;
import kz.RealIntertop.mapper.UserMapper;
import kz.RealIntertop.service.AccountService;
import kz.RealIntertop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/account")
public class AccountRestController {
    private final AccountService accountService;

    @PreAuthorize("isAnonymous()")
    @PostMapping(value = "/register")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        if(accountService.createUser(userDto)!=null){
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(409).build();
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        UserDto userDto = accountService.getUserById(id);
        if(userDto != null){
            return ResponseEntity.ok(userDto);
        }
        return ResponseEntity.status(404).build();
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping()
    public UserDto updateUser(
            @RequestBody UserDto userDto
    ) {
        return accountService.updateUser(userDto);
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping()
    public boolean deleteUser(
            @RequestBody Long id
    ) {
        return accountService.deleteUserById(id);
    }
}
