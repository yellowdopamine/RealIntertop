package kz.RealIntertop.service;

import kz.RealIntertop.dto.PictureDto;
import kz.RealIntertop.mapper.PictureMapper;
import kz.RealIntertop.models.item.Picture;
import kz.RealIntertop.repository.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PictureService {
    private final PictureRepository pictureRepository;
    private final PictureMapper pictureMapper;
    private final UserService userService;

    public PictureDto getById(Long id) {
        return pictureMapper.toDto(pictureRepository.findById(id).orElse(null));
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
}
