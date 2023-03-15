package kz.RealIntertop.controller.item.brand.collection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.RealIntertop.dto.BrandDto;
import kz.RealIntertop.dto.CollectionDto;
import kz.RealIntertop.service.CollectionService;
import kz.RealIntertop.service.SeasonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
