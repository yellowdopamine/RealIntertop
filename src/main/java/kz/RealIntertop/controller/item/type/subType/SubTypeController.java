package kz.RealIntertop.controller.item.type.subType;

import kz.RealIntertop.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/sub-type")
public class SubTypeController {
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @GetMapping()
    public String subTypes(){
        return "/item/type/sub-type/sub-types";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_MODER')")
    @GetMapping(value = "/details/{id}")
    public String subTypeDetails(@PathVariable(name = "id") Long id){
        return "/item/type/sub-type/sub-type-details";
    }
}
