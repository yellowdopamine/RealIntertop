package kz.intertop.controller.item.type;

import kz.intertop.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/type")
public class TypeController {
    private final TypeService typeService;
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @GetMapping()
    public String types(){
        return "/item/type/types";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_MODER')")
    @GetMapping(value = "/details/{id}")
    public String typeDetails(@PathVariable(name = "id") Long id){
        return "/item/type/type-details";
    }
}
