package kz.intertop.controller.account.cart;

import kz.intertop.dto.ItemDto;
import kz.intertop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
@RequestMapping("/api/cart")
public class CartRestController {
    private final CartService cartService;
    @GetMapping()
    public List<ItemDto> getCart(){
       return cartService.getCartItemsDto();
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id){
        cartService.deleteItem(id);
    }
    @PutMapping("/{id}")
    public void addItem(@PathVariable Long id){
        cartService.addItem(id);
    }
}
