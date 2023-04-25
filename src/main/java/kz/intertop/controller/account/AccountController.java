package kz.intertop.controller.account;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings("SameReturnValue")
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/account")
public class AccountController {
    @PreAuthorize("isAnonymous()")
    @GetMapping(value = "/register")
    public String register() {
        return "/account/register";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(value = "/sign-in")
    public String signIn() {
        return "/account/sign-in";
    }
}