package kz.RealIntertop.service;

import kz.RealIntertop.dto.CartDto;
import kz.RealIntertop.mapper.CartMapper;
import kz.RealIntertop.model.item.Item;
import kz.RealIntertop.model.user.User;
import kz.RealIntertop.repository.ItemRepository;
import kz.RealIntertop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartMapper cartMapper;
    private final UserService userService;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    public CartDto getCartDto(){
        User currentUser = userService.getCurrentUser();
        return cartMapper.toDto(currentUser.getCart());
    }
    public void addItem(Long itemId){
        User currentUser = userService.getCurrentUser();
        Set<Item> items = currentUser.getCart().getItems();
        items.add(itemRepository.findItemById(itemId));
        currentUser.getCart().setItems(items);
        userRepository.save(currentUser);
    }
    public void deleteItem(Long itemId){
        User currentUser = userService.getCurrentUser();
        Set<Item> items = currentUser.getCart().getItems();
        items.remove(itemRepository.findItemById(itemId));
        currentUser.getCart().setItems(items);
        userRepository.save(currentUser);
    }
}
