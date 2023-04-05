package kz.RealIntertop.service;

import kz.RealIntertop.dto.BrandDto;
import kz.RealIntertop.mapper.BrandMapper;
import kz.RealIntertop.model.item.Brand;
import kz.RealIntertop.model.item.Picture;
import kz.RealIntertop.repository.BrandRepository;
import kz.RealIntertop.repository.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    private final UserService userService;
    private final BrandMapper brandMapper;
    private final FileService fileService;
    private final PictureRepository pictureRepository;

    public BrandDto getById(Long id) {
        return brandMapper.toDto(brandRepository.findBrandById(id));
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

    public List<BrandDto> getAll() {
        return brandRepository.findAllByOrderByName().stream().map(brandMapper::toDto).collect(Collectors.toList());
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
}
