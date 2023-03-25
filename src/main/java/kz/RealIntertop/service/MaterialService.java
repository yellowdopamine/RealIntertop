package kz.RealIntertop.service;

import kz.RealIntertop.dto.MaterialDto;
import kz.RealIntertop.mapper.MaterialMapper;
import kz.RealIntertop.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MaterialService {
    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;
    public List<MaterialDto> getAllDto(){
        return materialRepository.getAllByOrderByName().stream().map(materialMapper::toDto).collect(Collectors.toList());
    }
    public MaterialDto getById(Long id){
        return materialMapper.toDto(materialRepository.findById(id).orElse(null));
    }
}
