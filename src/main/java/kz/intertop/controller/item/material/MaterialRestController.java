package kz.intertop.controller.item.material;

import kz.intertop.dto.MaterialDto;
import kz.intertop.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/material")
public class MaterialRestController {
    private final MaterialService materialService;

    @GetMapping("/all")
    public List<MaterialDto> getAll(){
        return materialService.getAllDto();
    }
}
