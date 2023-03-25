package kz.RealIntertop.service;

import kz.RealIntertop.dto.BrandDto;
import kz.RealIntertop.mapper.BrandMapper;
import kz.RealIntertop.model.item.Brand;
import kz.RealIntertop.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    private final UserService userService;
    private final BrandMapper brandMapper;

    public BrandDto create(BrandDto brandDto) {
        if (!userService.isModer() || brandRepository.findBrandByName(brandDto.getName()) != null) {
            return null;
        }
        Brand brand = brandMapper.toEntity(brandDto);
        return brandMapper.toDto(brandRepository.save(brand));
    }

    public BrandDto getById(Long id) {
        return brandMapper.toDto(brandRepository.findBrandById(id));
    }

    public BrandDto update(BrandDto brandDto) {
        Brand brand = brandRepository.findBrandById(brandDto.getId());
        if(!userService.isModer() && brand == null){
            return null;
        }
            brand.setName(brandDto.getName());
            brand.setPicture(brandDto.getPicture());
            return brandMapper.toDto(brandRepository.save(brand));
    }

    public void  deleteById(Long id) {
        Brand brand = brandRepository.findBrandById(id);
        if (brand != null) {
            if(userService.isModer()){
                brandRepository.deleteById(id);
            }
        }
    }

    public List<BrandDto> getAll() {
        return brandRepository.findAllByOrderByName().stream().map(brandMapper::toDto).collect(Collectors.toList());
    }
}
