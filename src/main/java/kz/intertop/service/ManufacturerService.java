package kz.intertop.service;

import kz.intertop.dto.ManufacturerDto;
import kz.intertop.mapper.ManufacturerMapper;
import kz.intertop.models.item.Manufacturer;
import kz.intertop.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerMapper manufacturerMapper;
    private Map<Long, ManufacturerDto> manufacturersDtoMap;
    @PostConstruct
    public void update() {
        manufacturersDtoMap = getAllDto().stream().collect(Collectors.toMap(ManufacturerDto::getId, Function.identity()));
    }

    public List<ManufacturerDto> getAllDto(){
        return manufacturerRepository.findAll().stream().map(manufacturerMapper::toDto).collect(Collectors.toList());
    }
    public List<Manufacturer> getAll(){
        return manufacturerRepository.findAll();
    }
    public ManufacturerDto getByIdDto(Long id){
        return manufacturersDtoMap.get(id);
    }

}
