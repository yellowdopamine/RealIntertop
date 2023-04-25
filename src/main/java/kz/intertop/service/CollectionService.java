package kz.intertop.service;

import kz.intertop.dto.CollectionDto;
import kz.intertop.mapper.CollectionMapper;
import kz.intertop.models.item.Collection;
import kz.intertop.repository.BrandRepository;
import kz.intertop.repository.CollectionRepository;
import kz.intertop.repository.ManufacturerRepository;
import kz.intertop.repository.SeasonRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CollectionService {
    private final CollectionRepository collectionRepository;
    private final UserService userService;
    private final CollectionMapper collectionMapper;
    private final BrandRepository brandRepository;
    private final SeasonRepository seasonRepository;
    private final ManufacturerRepository manufacturerRepository;
    @Getter
    private Map<Long, CollectionDto> collectionsDtoMap;
    @Getter
    private Map<Long, Collection> collectionsMap;

    @PostConstruct
    public void initCollectionMaps() {
        List<Collection> allCollections = collectionRepository.findAllByOrderByBrand();
        collectionsDtoMap = allCollections.stream().map(collectionMapper::toDto).collect(Collectors.toMap(CollectionDto::getId, Function.identity()));
        collectionsMap = allCollections.stream().collect(Collectors.toMap(Collection::getId, Function.identity()));
    }
    public CollectionDto getByIdDto(Long id){
        return collectionsDtoMap.get(id);
    }
    public Collection getById(Long id){
        return collectionsMap.get(id);
    }

    public CollectionDto create(CollectionDto collectionDto) {
        if (!userService.isModer() || collectionRepository.findCollectionByName(collectionDto.getName()) != null) {
            return null;
        }
        Collection collection = collectionMapper.toEntity(collectionDto);
        assign(collectionDto, collection);
        return collectionMapper.toDto(collectionRepository.save(collection));
    }

    public List<CollectionDto> getByBrandId(Long id) {
        return collectionRepository.findAllByBrandId(id).stream().map(collectionMapper::toDto)
                .toList();
    }
    public List<CollectionDto> getAllDto() {
        return collectionRepository.findAllByOrderByBrand().stream().map(collectionMapper::toDto)
                .toList();
    }

    public CollectionDto update(CollectionDto collectionDto) {
        Collection collection = collectionRepository.findCollectionById(collectionDto.getId());
        if (!userService.isModer() || collection == null) {
            return null;
        }
        collection.setYear(collectionDto.getYear());
        collection.setName(collectionDto.getName());

        assign(collectionDto, collection);
        return collectionMapper.toDto(collectionRepository.save(collection));
    }

    public void deleteById(Long id) {
        if (userService.isModer()) {
            collectionRepository.deleteById(id);
        }
    }

    private void assign(CollectionDto collectionDto, Collection collection) {
        Long seasonId = collectionDto.getSeason().getId();
        Long brandId = collectionDto.getBrand().getId();
        Long manufacturerId = collectionDto.getManufacturer().getId();

        collection.setBrand(brandRepository.findBrandById(brandId));
        collection.setSeason(seasonRepository.findSeasonById(seasonId));
        collection.setManufacturer(manufacturerRepository.findManufacturerById(manufacturerId));
    }
}