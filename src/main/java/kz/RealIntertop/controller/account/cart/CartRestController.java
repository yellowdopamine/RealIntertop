package kz.RealIntertop.controller.account.cart;

import kz.RealIntertop.dto.CartDto;
import kz.RealIntertop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
@RequestMapping("/api/cart")
public class CartRestController {
    private CartService cartService;
    @GetMapping()
    public CartDto getCart(){
       return cartService.getCartDto();
    }
    @DeleteMapping()
    public void deleteItem(@RequestParam Long itemId){
        cartService.deleteItem(itemId);
    }
    @PutMapping()
    public void addItem(@RequestParam Long itemId){
        cartService.addItem(itemId);
    }
}
