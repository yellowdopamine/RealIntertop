package kz.intertop.controller.item.brand.collection;

import kz.intertop.dto.ManufacturerDto;
import kz.intertop.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/manufacturer")
public class ManufacturerRestController {
    private final ManufacturerService manufacturerService;
    @GetMapping("/all")
    public List<ManufacturerDto> getAll() {
        return manufacturerService.getAllDto();
    }

}
