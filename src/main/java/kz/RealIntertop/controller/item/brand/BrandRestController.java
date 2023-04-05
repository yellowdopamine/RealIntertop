package kz.RealIntertop.controller.item.brand;

import kz.RealIntertop.dto.BrandDto;
import kz.RealIntertop.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/brand")
public class BrandRestController {
    private final BrandService brandService;

    @PostMapping()
    public BrandDto create(@RequestBody BrandDto brandDto) {
        return brandService.create(brandDto);
    }

    @PutMapping()
    public BrandDto update(@RequestBody BrandDto brandDto) {
        return brandService.update(brandDto);
    }

    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @PostMapping("/picture/{id}")
    public void setPicture(
            @RequestParam (name = "picture") MultipartFile file,
            @PathVariable Long id){
        brandService.setPicture(file, id);
    }
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @DeleteMapping("/picture/{id}")
    public void deletePicture(
            @PathVariable Long id) throws IOException {
        brandService.deletePicture(id);
    }

    @GetMapping("/all")
    public List<BrandDto> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public BrandDto getById(@PathVariable Long id) {
        return brandService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        brandService.deleteById(id);
    }
}
