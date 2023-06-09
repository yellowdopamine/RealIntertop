package kz.intertop.service;

import kz.intertop.dto.ItemDto;
import kz.intertop.mapper.ItemMapper;
import kz.intertop.models.item.*;
import kz.intertop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final BrandService brandService;
    private final ItemRepository itemRepository;
    private final PictureRepository pictureRepository;
    private final ItemMapper itemMapper;
    private final UserService userService;
    private final FileService fileService;
    private final MaterialService materialService;
    private final SubTypeService subTypeService;
    private final TypeService typeService;
    private final GenderService genderService;
    private final ColorService colorService;
    private final CollectionService collectionService;

    public ItemDto createItem(ItemDto itemDto) {
        if (!userService.isModer()) {
            return null;
        }
        Item item = new Item();
        assignElements(itemDto, item);
        return itemMapper.toDto(itemRepository.save(item));
    }

    public void addPictures(List<MultipartFile> fileList, Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        List<Picture> pictures = item.getPictures();
        for (MultipartFile file : fileList) {
            String fileName = fileService.uploadFile(file);
            pictures.add(pictureRepository.save(Picture.builder().name(fileName).build()));
        }
        item.setPictures(pictures);
        itemRepository.save(item);
    }

    public void deletePicture(String pictureName, Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        List<Picture> pictures = item.getPictures();
        pictures.remove(pictureRepository.findPictureByName(pictureName));
        fileService.deleteFile(pictureName);
        item.setPictures(pictures);
        itemRepository.save(item);
    }

    public ItemDto getItemByIdDto(Long id) {
        return itemMapper.toDto(itemRepository.findById(id).orElse(null));
    }

    public ItemDto updateItem(ItemDto itemDto) {
        Item item = itemRepository.findById(itemDto.getId()).orElseThrow();
        assignElements(itemDto, item);
        return itemMapper.toDto(itemRepository.save(item));
    }

    public void deleteByItemId(Long id) {
        if (userService.isModer()) {
            itemRepository.deleteById(id);
        }
    }

    public List<ItemDto> getAllDto() {
        return itemRepository.findAll().stream().map(itemMapper::toDto).toList();
    }

    public List<ItemDto> search(
            String key,
            Double minPrice,
            Double maxPrice,
            List<Long> brandIds,
            List<Long> typeIds,
            List<Long> materialIds,
            List<Long> colorIds,
            Boolean child,
            Long genderId
    ) {

        List<Material> materials = materialService.getAllByIdIn(materialIds);
        List<Color> colors = colorService.getAllByIdIn(colorIds);
        List<Brand> brands = brandService.getAllByIdIn(brandIds);
        List<Type> types = typeService.getAllByIdIn(typeIds);
        Gender gender = genderService.getById(genderId);

        return itemRepository.customSearch(
                key,
                key,
                minPrice,
                maxPrice,
                brands,
                types,
                gender,
                child,
                materials,
                colors
        ).stream().map(itemMapper::toDto).toList();
    }

    public List<ItemDto> getAllByCollectionIdDto(Long id) {
        return itemRepository.findAllByCollectionId(id).stream().map(itemMapper::toDto).toList();
    }

    private void assignElements(ItemDto itemDto, Item item) {
        List<Material> materials = itemDto.getMaterials().stream()
                .map(materialDto -> materialService.getById(materialDto.getId()))
                .toList();
        List<Color> colors = itemDto.getColors().stream()
                .map(colorDto -> colorService.getById(colorDto.getId()))
                .toList();
        item.setCollection(collectionService.getById(itemDto.getCollection().getId()));
        item.setSubType(subTypeService.getById(itemDto.getSubType().getId()));
        item.setGender(genderService.getById(itemDto.getGender().getId()));
        item.setBrand(brandService.getById(itemDto.getBrand().getId()));
        item.setId(itemDto.getId());
        item.setModelName(itemDto.getModelName());
        item.setPrice(itemDto.getPrice());
        item.setMaterials(materials);
        item.setColors(colors);
        item.setChild(itemDto.isChild());
        item.setArticle(itemDto.getArticle());
        item.setContent(itemDto.getContent());
    }
}