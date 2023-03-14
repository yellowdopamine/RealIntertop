package kz.RealIntertop.service;

import kz.RealIntertop.dto.ColorDto;
import kz.RealIntertop.dto.MaterialDto;
import kz.RealIntertop.mapper.ColorMapper;
import kz.RealIntertop.mapper.MaterialMapper;
import kz.RealIntertop.repository.ColorRepository;
import kz.RealIntertop.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColorService {
    private final ColorRepository colorRepository;
    private final ColorMapper colorMapper;
    public List<ColorDto> getAllDto(){
        return colorRepository.getAllByOrderByName().stream().map(colorMapper::toDto).collect(Collectors.toList());
    }
    public ColorDto getByIdDto(Long id){
        return colorMapper.toDto(colorRepository.findById(id).orElse(null));
    }
}
