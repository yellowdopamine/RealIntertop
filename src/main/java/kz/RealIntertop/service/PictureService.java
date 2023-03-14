package kz.RealIntertop.service;

import kz.RealIntertop.dto.ItemDto;
import kz.RealIntertop.dto.PictureDto;
import kz.RealIntertop.dto.TypeDto;
import kz.RealIntertop.mapper.PictureMapper;
import kz.RealIntertop.mapper.TypeMapper;
import kz.RealIntertop.model.item.Picture;
import kz.RealIntertop.model.item.Type;
import kz.RealIntertop.repository.PictureRepository;
import kz.RealIntertop.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
