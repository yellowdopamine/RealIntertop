package kz.intertop.controller.item;
import kz.intertop.dto.ItemDto;
import kz.intertop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/item")
public class ItemRestController {
    private final ItemService itemService;
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @PostMapping()
    public ItemDto createItem(@RequestBody ItemDto itemDto){
        return itemService.createItem(itemDto);
    }

    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @PostMapping("/pictures/{id}")
    public void addImages(
            @RequestParam (name = "itemPictures") List<MultipartFile> fileList,
            @PathVariable Long id){
        itemService.addPictures(fileList, id);
    }
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @DeleteMapping("/pictures/{pictureName}/{id}")
    public void deletePicture(
            @PathVariable String pictureName,
            @PathVariable Long id) throws IOException {
        itemService.deletePicture(pictureName, id);
    }
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @PutMapping()
    public ItemDto updateItem(@RequestBody ItemDto itemDto) {
        return itemService.updateItem(itemDto);
    }

    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        itemService.deleteByItemId(id);
    }

    @GetMapping("/all")
    public List<ItemDto> getAll() {
        return itemService.getAllDto();
    }
    @GetMapping("/search/")
    public List<ItemDto> search(
            @RequestParam(name = "modelName", required = false) String modelName,
            @RequestParam(name = "child", required = false, defaultValue = "false") Boolean child,
            @RequestParam(name = "maxPrice", required = false) Double maxPrice,
            @RequestParam(name = "minPrice", required = false) Double minPrice,
            @RequestParam(name = "brandId", required = false) ArrayList<Long> brandIds,
            @RequestParam(name = "materialId", required = false) List<Long> materialIds,
            @RequestParam(name = "typeId", required = false) ArrayList<Long> typeIds,
            @RequestParam(name = "colorId", required = false) List<Long> colorIds,
            @RequestParam(name = "genderId", required = false) Long genderId
    ) {
        return itemService.search(
                modelName,
                minPrice,
                maxPrice,
                brandIds,
                typeIds,
                materialIds,
                colorIds,
                child,
                genderId
        );
    }

    @GetMapping("/{id}")
    public ItemDto getById(@PathVariable Long id) {
        return itemService.getItemByIdDto(id);
    }
    @GetMapping("/get-by-collection-id/{id}")
    public List<ItemDto> getByCollectionId(@PathVariable Long id) {
        return itemService.getAllByCollectionIdDto(id);
    }
}
