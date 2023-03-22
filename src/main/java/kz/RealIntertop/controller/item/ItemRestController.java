package kz.RealIntertop.controller.item;

import kz.RealIntertop.dto.ItemDto;
import kz.RealIntertop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @PutMapping("/pictures/set-avatar/{pictureName}/{id}")
    public void setAvatar(
            @PathVariable String pictureName,
            @PathVariable Long id){
        itemService.setAvatar(pictureName, id);
    }
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @DeleteMapping("/pictures/{pictureName}/{id}")
    public void deletePicture(
            @PathVariable String pictureName,
            @PathVariable Long id){
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
    @GetMapping("/search")
    public List<ItemDto> search(
//            @RequestParam (name = "priceFrom") Double priceFrom
    ) {
        return itemService.getAllDto();
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
