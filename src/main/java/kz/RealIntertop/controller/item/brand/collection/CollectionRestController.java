package kz.RealIntertop.controller.item.brand.collection;

import kz.RealIntertop.dto.CollectionDto;
import kz.RealIntertop.service.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/collection")
public class CollectionRestController {
    private final CollectionService collectionService;

    @PostMapping()
    public CollectionDto create(@RequestBody CollectionDto collectionDto) {
        return collectionService.create(collectionDto);
    }

    @GetMapping("/{id}")
    public CollectionDto getById(@PathVariable Long id) {
        return collectionService.getById(id);
    }
    @GetMapping(value = "/get-by-brand/{id}")
    public List<CollectionDto> getByBrandId(@PathVariable Long id) {
        return collectionService.getByBrandId(id);
    }

    @PutMapping()
    public CollectionDto update(@RequestBody CollectionDto collectionDto) {
        return collectionService.update(collectionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        collectionService.deleteById(id);
    }

    @GetMapping("/all")
    public List<CollectionDto> getAll() {
        return collectionService.getAll();
    }

}
