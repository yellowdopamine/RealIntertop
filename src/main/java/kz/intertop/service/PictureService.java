package kz.intertop.service;

import kz.intertop.dto.PictureDto;
import kz.intertop.mapper.PictureMapper;
import kz.intertop.models.item.Picture;
import kz.intertop.repository.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PictureService {
    private final PictureRepository pictureRepository;
    private final PictureMapper pictureMapper;
    private final UserService userService;
    private Map<Long, PictureDto> picturesDtoMap;
    private Map<Long, Picture> picturesMap;

    @PostConstruct
    public void initPictureMaps() {
        List<Picture> allPictures = pictureRepository.findAll();
        picturesDtoMap = allPictures.stream().map(pictureMapper::toDto).collect(Collectors.toMap(PictureDto::getId, Function.identity()));
        picturesMap = allPictures.stream().collect(Collectors.toMap(Picture::getId, Function.identity()));
    }

    public PictureDto getByIdDto(Long id) {
        return picturesDtoMap.get(id);
    }
    public Picture getById(Long id) {
        return picturesMap.get(id);
    }

    public PictureDto create(PictureDto pictureDto) {
        if(!userService.isModer() || pictureDto == null){
            return null;
        }
        return pictureMapper.toDto(pictureRepository.save(pictureMapper.toEntity(pictureDto)));
    }

    public String deleteById(Long id) {
        String response = "WRONG_ID";
        Picture picture = pictureRepository.findById(id).orElse(null);
        if (picture != null) {
            response = "ACCESS_DENIED";
            if (userService.isModer()) {
                pictureRepository.deleteById(id);
                response = "DELETED";
            }
        }
        return response;
    }
    public List<PictureDto> getAllDto(){
        return pictureRepository.findAll().stream().map(pictureMapper::toDto).toList();
    }
}
