package kz.RealIntertop.controller.item.brand.collection.season;

import kz.RealIntertop.dto.SeasonDto;
import kz.RealIntertop.service.SeasonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/season")
public class SeasonRestController {
    private final SeasonService seasonService;
    @GetMapping(value = "/all")
    public List<SeasonDto> getAllDto(){
        return seasonService.getAllDto();
    }
}
