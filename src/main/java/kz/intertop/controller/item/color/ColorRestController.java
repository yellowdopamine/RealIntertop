package kz.intertop.controller.item.color;

import kz.intertop.dto.ColorDto;
import kz.intertop.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/color")
public class ColorRestController {
    private final ColorService colorService;

    @GetMapping("/all")
    public List<ColorDto> getAll(){
        return colorService.getAllDto();
    }
}
