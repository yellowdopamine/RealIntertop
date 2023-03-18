package kz.RealIntertop.controller.item;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/item")
public class ItemController {
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @GetMapping("")
    public String itemPage(){
        return "/item/items";
    }
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @GetMapping("/create")
    public String createItem(Model model){
        return "/item/item-create";
    }
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @GetMapping("/details/{id}")
    public String itemDetails(@PathVariable Long id){
        return "/item/item-details";
    }
    @GetMapping("/view/{id}")
    public String itemView(@PathVariable Long id){
        return "/item/item-view";
    }
}
