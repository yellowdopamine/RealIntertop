package kz.RealIntertop.controller.item.brand.collection;

import kz.RealIntertop.dto.CollectionDto;
import kz.RealIntertop.dto.ManufacturerDto;
import kz.RealIntertop.service.CollectionService;
import kz.RealIntertop.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/manufacturer")
public class ManufacturerRestController {
    private final ManufacturerService manufacturerService;
    @GetMapping("/all")
    public List<ManufacturerDto> getAll() {
        return manufacturerService.getAllDto();
    }

}
