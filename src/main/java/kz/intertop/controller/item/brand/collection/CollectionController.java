package kz.intertop.controller.item.brand.collection;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/collection")
public class CollectionController {

    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @GetMapping()
    public String collections(){
        return "item/collection/collections";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_MODER')")
    @GetMapping(value = "/details/{id}")
    public String collectionDetails(@PathVariable Long id) {
        return "item/collection/collection-details";
    }
}
