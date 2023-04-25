package kz.intertop.controller.item.brand;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/brand")
public class BrandController {
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @GetMapping()
    public String brands(){
        return "/item/brand/brands";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_MODER')")
    @GetMapping(value = "/details/{id}")
    public String brandDetails(@PathVariable(name = "id") Long id){
        return "/item/brand/brand-details";
    }
}
