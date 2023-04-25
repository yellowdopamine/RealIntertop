package kz.intertop.service;

import kz.intertop.dto.BrandDto;
import kz.intertop.mapper.BrandMapper;
import kz.intertop.models.item.Brand;
import kz.intertop.models.item.Picture;
import kz.intertop.repository.BrandRepository;
import kz.intertop.repository.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    private final UserService userService;
    private final BrandMapper brandMapper;
    private final FileService fileService;
    private final PictureRepository pictureRepository;
    private Map<Long, BrandDto> brandsDtoMap;
    private Map<Long, Brand> brandsMap;

    @PostConstruct
    public void initBrandMaps() {
        List<Brand> allBrands = getAllBrands();
        brandsDtoMap = allBrands.stream().map(brandMapper::toDto).collect(Collectors.toMap(BrandDto::getId, Function.identity()));
        brandsMap = allBrands.stream().collect(Collectors.toMap(Brand::getId, Function.identity()));
    }
    public BrandDto getByIdDto(Long id) {
        return brandsDtoMap.get(id);
    }
    public Brand getById(Long id){
        return brandsMap.get(id);
    }
    public List<Brand> getAllByIdIn(List<Long> brandIds) {
        return brandIds.stream()
                .map(brandsMap::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }


    public BrandDto create(BrandDto brandDto) {
        if (!userService.isModer() || brandRepository.findBrandByName(brandDto.getName()) != null) {
            return null;
        }
        Brand brand = brandMapper.toEntity(brandDto);
        return brandMapper.toDto(brandRepository.save(brand));
    }

    public BrandDto update(BrandDto brandDto) {
        Brand brand = brandRepository.findBrandById(brandDto.getId());
        if (!userService.isModer() && brand == null) {
            return null;
        }
        brand.setName(brandDto.getName());
        brand.setPicture(brandDto.getPicture());
        return brandMapper.toDto(brandRepository.save(brand));
    }

    public void deleteById(Long id) {
        Brand brand = brandRepository.findBrandById(id);
        if (brand != null) {
            if (userService.isModer()) {
                brandRepository.deleteById(id);
            }
        }
    }


    public void setPicture(MultipartFile file, Long brandId){
        Brand brand = brandRepository.findBrandById(brandId);
        String fileName = fileService.uploadFile(file);
        Picture picture = pictureRepository.save(Picture.builder().name(fileName).build());
        brand.setPicture(picture);
        brandRepository.save(brand);
    }
    public void deletePicture(Long brandId){
        Brand brand = brandRepository.findBrandById(brandId);
        fileService.deleteFile(brand.getPicture().getName());
        brand.setPicture(null);
        brandRepository.save(brand);
    }
    public List<BrandDto> getAllDto() {
        return getAllBrands().stream().map(brandMapper::toDto).toList();
    }
    public List<Brand> getAllBrands() {
        return brandRepository.findAllByOrderByName();
    }
}
