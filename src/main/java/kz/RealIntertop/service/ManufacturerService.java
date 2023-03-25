package kz.RealIntertop.service;

import kz.RealIntertop.dto.ManufacturerDto;
import kz.RealIntertop.mapper.ManufacturerMapper;
import kz.RealIntertop.model.item.Manufacturer;
import kz.RealIntertop.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerMapper manufacturerMapper;

    public List<ManufacturerDto> getAllDto(){
        return manufacturerRepository.findAll().stream().map(manufacturerMapper::toDto).collect(Collectors.toList());
    }
    public List<Manufacturer> getAll(){
        return manufacturerRepository.findAll();
    }
    public ManufacturerDto getById(Long id){
        return manufacturerMapper.toDto(manufacturerRepository.findManufacturerById(id));
    }
}
