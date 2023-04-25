package kz.intertop.service;

import kz.intertop.dto.ColorDto;
import kz.intertop.mapper.ColorMapper;
import kz.intertop.models.item.Color;
import kz.intertop.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColorService {
    private final ColorRepository colorRepository;
    private final ColorMapper colorMapper;

    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    public List<ColorDto> getAllDto() {
        return getAllColors().stream().map(colorMapper::toDto).toList();
    }

    public Color getById(Long id) {
        return colorsMap.get(id);
    }

    public List<Color> getAllByIdIn(List<Long> colorIds) {
        return colorIds.stream()
                .map(colorsMap::get)
                .filter(Objects::nonNull)
                .toList();
    }


    private Map<Long, ColorDto> colorsDtoMap;
    private Map<Long, Color> colorsMap;

    @PostConstruct
    public void initColorMaps() {
        List<Color> allColors = getAllColors();
        colorsDtoMap = allColors.stream().map(colorMapper::toDto).collect(Collectors.toMap(ColorDto::getId, Function.identity()));
        colorsMap = allColors.stream().collect(Collectors.toMap(Color::getId, Function.identity()));
    }
}
