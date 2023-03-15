package kz.RealIntertop.controller.item;

import kz.RealIntertop.dto.ItemDto;
import kz.RealIntertop.model.item.Item;
import kz.RealIntertop.repository.ItemRepository;
import kz.RealIntertop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/item")
public class ItemRestController {
    private final ItemRepository itemRepository;
    private final ItemService itemService;
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @PostMapping()
    public ItemDto createItem(@RequestBody ItemDto itemDto){
        return itemService.createItem(itemDto);
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

    @GetMapping("/{id}")
    public ItemDto getById(@PathVariable Long id) {
        return itemService.getItemByIdDto(id);
    }
    @GetMapping("/get-by-collection-id/{id}")
    public List<ItemDto> getByCollectionId(@PathVariable Long id) {
        return itemService.getAllByCollectionIdDto(id);
//        return itemRepository.findAllByCollectionId(id);
    }
}
