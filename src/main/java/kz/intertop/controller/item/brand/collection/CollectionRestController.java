package kz.intertop.controller.item.brand.collection;

import kz.intertop.dto.CollectionDto;
import kz.intertop.service.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/collection")
public class CollectionRestController {
    private final CollectionService collectionService;

    @PostMapping()
    public CollectionDto create(@RequestBody CollectionDto collectionDto) {
        return collectionService.create(collectionDto);
    }

    @GetMapping("/{id}")
    public CollectionDto getById(@PathVariable Long id) {
        return collectionService.getByIdDto(id);
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
        return collectionService.getAllDto();
    }

}
