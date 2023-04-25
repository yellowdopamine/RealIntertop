package kz.intertop.mapper;

import kz.intertop.dto.PictureDto;
import kz.intertop.models.item.Picture;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PictureMapper {
    Picture toEntity(PictureDto pictureDto);
    PictureDto toDto(Picture picture);
}
