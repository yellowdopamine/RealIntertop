package kz.intertop.controller.account.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
@RequestMapping(value = "/cart")
public class CartController {
    @GetMapping()
    public String cartPage(){
        return "/account/cart";
    }
}
