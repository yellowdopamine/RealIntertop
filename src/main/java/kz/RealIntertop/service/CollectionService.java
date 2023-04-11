package kz.RealIntertop.service;

import kz.RealIntertop.dto.CollectionDto;
import kz.RealIntertop.mapper.CollectionMapper;
import kz.RealIntertop.models.item.Collection;
import kz.RealIntertop.repository.BrandRepository;
import kz.RealIntertop.repository.CollectionRepository;
import kz.RealIntertop.repository.ManufacturerRepository;
import kz.RealIntertop.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public CollectionDto create(CollectionDto collectionDto) {
        if (!userService.isModer() || collectionRepository.findCollectionByName(collectionDto.getName()) != null) {
            return null;
        }
        Collection collection = collectionMapper.toEntity(collectionDto);
        assign(collectionDto, collection);
        return collectionMapper.toDto(collectionRepository.save(collection));
    }

    public CollectionDto getById(Long id) {
        return collectionMapper.toDto(collectionRepository.findCollectionById(id));
    }

    public List<CollectionDto> getByBrandId(Long id) {
        return collectionRepository.findAllByBrandId(id).stream().map(collectionMapper::toDto)
                .collect(Collectors.toList());
    }
    public List<CollectionDto> getAll() {
        return collectionRepository.findAllByOrderByBrand().stream().map(collectionMapper::toDto)
                .collect(Collectors.toList());
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