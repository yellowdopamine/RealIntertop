package kz.intertop.service;

import kz.intertop.dto.ItemDto;
import kz.intertop.mapper.CartMapper;
import kz.intertop.mapper.ItemMapper;
import kz.intertop.models.item.Cart;
import kz.intertop.models.item.Item;
import kz.intertop.models.user.User;
import kz.intertop.repository.CartRepository;
import kz.intertop.repository.ItemRepository;
import kz.intertop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartMapper cartMapper;
    private final UserService userService;
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final UserRepository userRepository;
    private User getCurrentUser(){
        return userService.getCurrentUser();
    }

    public List<ItemDto> getCartItemsDto(){
        User currentUser = getCurrentUser();
        Cart cart = cartRepository.findCartById(currentUser.getCart().getId());
        Set<Item> items = cart.getItems();
        return items.stream().map(itemMapper::toDto).toList();
    }
    public void addItem(Long itemId){
        User currentUser = getCurrentUser();
        Cart cart = cartRepository.findCartById(currentUser.getCart().getId());
        Set<Item> items = cart.getItems();
        items.add(itemRepository.findItemById(itemId));
        cart.setItems(items);
        cartRepository.save(cart);
    }
    public void deleteItem(Long itemId){
        User currentUser = getCurrentUser();
        Set<Item> items = currentUser.getCart().getItems();
        items.remove(itemRepository.findItemById(itemId));
        currentUser.getCart().setItems(items);
        userRepository.save(currentUser);
    }
}
