package kz.intertop.service;

import kz.intertop.dto.MaterialDto;
import kz.intertop.mapper.MaterialMapper;
import kz.intertop.models.item.Material;
import kz.intertop.repository.MaterialRepository;
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
public class MaterialService {
    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;
    private Map<Long, MaterialDto> materialsDtoMap;
    private Map<Long, Material> materialsMap;

    @PostConstruct
    public void initMaterialMaps() {
        List<Material> allMaterials = materialRepository.getAllByOrderByName();
        materialsDtoMap = allMaterials.stream().map(materialMapper::toDto).collect(Collectors.toMap(MaterialDto::getId, Function.identity()));
        materialsMap = allMaterials.stream().collect(Collectors.toMap(Material::getId, Function.identity()));
    }

    public List<MaterialDto> getAllDto() {
        return materialRepository.getAllByOrderByName().stream().map(materialMapper::toDto).toList();
    }

    public List<Material> getAll() {
        return materialRepository.getAllByOrderByName();
    }
    public List<Material> getAllByIdIn(List<Long> materialIds) {
        return materialIds.stream()
                .map(materialsMap::get)
                .filter(Objects::nonNull)
                .toList();
    }


    public MaterialDto getByIdDto(Long id) {
        return materialsDtoMap.get(id);
    }

    public Material getById(Long id) {
        return materialsMap.get(id);
    }
    public List<Material> getByIdIn(List<Long> materialIds){
        return materialIds.stream().map(this::getById).toList();
    }
}
