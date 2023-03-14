package kz.RealIntertop.controller.item.brand;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.RealIntertop.dto.BrandDto;
import kz.RealIntertop.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/brand")
public class BrandController {
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @GetMapping()
    public String brands(Model model) throws JsonProcessingException {
        return "/item/brand/brands";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_MODER')")
    @GetMapping(value = "/details/{id}")
    public String brandDetails(@PathVariable(name = "id") Long id){
        return "/item/brand/brand-details";
    }
}
