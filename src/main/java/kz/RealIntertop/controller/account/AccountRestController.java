package kz.RealIntertop.controller.account;

import kz.RealIntertop.dto.UserDto;
import kz.RealIntertop.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/account")
public class AccountRestController {
    private final AccountService accountService;

    @PreAuthorize("isAnonymous()")
    @PostMapping(value = "/register")
    public UserDto createUser(@RequestBody UserDto userDto){
        return accountService.createUser(userDto);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return accountService.getUserById(id);
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
