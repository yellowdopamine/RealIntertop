package kz.RealIntertop.service;

import kz.RealIntertop.dto.ItemDto;
import kz.RealIntertop.mapper.ItemMapper;
import kz.RealIntertop.model.item.*;
import kz.RealIntertop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
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
        return itemRepository.findAll().stream().map(itemMapper::toDto).collect(Collectors.toList());
    }

    public List<ItemDto> search(
            String modelName,
//            String article,
//            int minDiscount,
//            int maxDiscount,
            boolean isChild,
            double minPrice,
            double maxPrice,
            List<Long> brandIds,
            List<Long> materialIds,
            List<Long> typeIds,
            List<Long> colorIds,
            Long genderId
    ) {
//        List<? extends Serializable> searchParameters = Arrays.asList(
//                modelName,
//                article,
//                minDiscount,
//                maxDiscount,
//                isChild,
//                minPrice,
//                maxPrice
//        );

        modelName = "%" + modelName + "%";
//        article = "%" + article + "%";

        List<Material> materials = materialRepository.findByIdIn(materialIds);
        List<Color> colors = colorRepository.findByIdIn(colorIds);
        Gender gender = genderRepository.findGenderById(genderId);

        return itemRepository.findByModelNameContainingAndPriceBetweenAndCollectionBrandIdInAndSubTypeIdInAndIsChildAndMaterialsInAndColorsInAndGender(
                modelName,
//                minDiscount,
//                maxDiscount,
                minPrice,
                maxPrice,
                brandIds,
                typeIds,
                isChild,
                materials,
                colors,
                gender
        ).stream().map(itemMapper::toDto).collect(Collectors.toList());
    }

    public List<ItemDto> getAllByCollectionIdDto(Long id) {
        return itemRepository.findAllByCollectionId(id).stream().map(itemMapper::toDto).collect(Collectors.toList());
    }

    private void assignElements(ItemDto itemDto, Item item) {
        List<Material> materials = itemDto.getMaterials().stream()
                .map(materialDto -> materialRepository.findById(materialDto.getId())
                        .orElseThrow()).toList();
        List<Color> colors = itemDto.getColors().stream()
                .map(colorDto -> colorRepository.findById(colorDto.getId())
                        .orElseThrow()).toList();
        item.setId(itemDto.getId());
        item.setModelName(itemDto.getModelName());
        item.setPrice(itemDto.getPrice());
        item.setCollection(collectionRepository.findCollectionById(itemDto.getCollection().getId()));
        item.setSubType(subTypeRepository.findSubTypeById(itemDto.getSubType().getId()));
        item.setGender(genderRepository.findGenderById(itemDto.getGender().getId()));
        item.setMaterials(new HashSet<>(materials));
        item.setColors(new HashSet<>(colors));
        item.setChild(itemDto.isChild());
        item.setArticle(itemDto.getArticle());
        item.setContent(itemDto.getContent());
    }
}