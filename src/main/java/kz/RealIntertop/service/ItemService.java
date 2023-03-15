package kz.RealIntertop.service;

import kz.RealIntertop.dto.ItemDto;
import kz.RealIntertop.mapper.ItemMapper;
import kz.RealIntertop.model.item.Color;
import kz.RealIntertop.model.item.Item;
import kz.RealIntertop.model.item.Material;
import kz.RealIntertop.model.item.Picture;
import kz.RealIntertop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final UserService userService;
    private final FileService fileService;
    private final PictureRepository pictureRepository;
    private final CollectionRepository collectionRepository;
    private final SubTypeRepository subTypeRepository;
    private final MaterialRepository materialRepository;
    private final ColorRepository colorRepository;
    private final GenderRepository genderRepository;
    public ItemDto createItem(ItemDto itemDto) {
        if (!userService.isModer()) {
            return null;
        }
        List<Material> materials = itemDto.getMaterials().stream()
                .map(materialDto -> materialRepository.findById(materialDto.getId())
                        .orElseThrow()).toList();
        List<Color> colors = itemDto.getColors().stream()
                .map(colorDto -> colorRepository.findById(colorDto.getId())
                        .orElseThrow()).toList();
        Item item = Item
                .builder()
                .modelName(itemDto.getModelName())
                .price(itemDto.getPrice())
                .collection(collectionRepository.findCollectionById(itemDto.getCollection().getId()))
                .subType(subTypeRepository.findSubTypeById(itemDto.getSubType().getId()))
                .gender(genderRepository.findGenderById(itemDto.getGender().getId()))
                .materials(Set.copyOf(materials))
                .colors(Set.copyOf(colors))
                .isChild(itemDto.isChild())
                .build();

        if (itemDto.getFileList() != null) {
            List<Picture> pictures = new ArrayList<>();
            for (MultipartFile file : itemDto.getFileList()) {
                String fileName = fileService.uploadFile(file);
                pictures.add(pictureRepository.save(Picture.builder().name(fileName).build()));
            }
            item.setPictures(pictures);
        }
        return itemMapper.toDto(itemRepository.save(item));
    }

    public ItemDto getItemByIdDto(Long id) {
        return itemMapper.toDto(itemRepository.findById(id).orElse(null));
    }

    public ItemDto updateItem(ItemDto itemDto) {
        if (!itemRepository.existsById(itemDto.getId())) {
            return null;
        }
        Item item = itemMapper.toEntity(itemDto);
        return itemMapper.toDto(itemRepository.save(item));
    }

    public void deleteByItemId(Long id) {
        if (userService.isModer()) {
            itemRepository.deleteById(id);
        }
    }

    public List<ItemDto> getAllDto() {
        return itemRepository.findAll().stream().map(itemMapper::toDto).collect(Collectors.toList());
    }
    public List<ItemDto> getAllByCollectionIdDto(Long id) {
        return itemRepository.findAllByCollectionId(id).stream().map(itemMapper::toDto).collect(Collectors.toList());
    }
}
