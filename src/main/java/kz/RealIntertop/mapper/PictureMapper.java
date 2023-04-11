package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.PictureDto;
import kz.RealIntertop.models.item.Picture;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PictureMapper {
    Picture toEntity(PictureDto pictureDto);
    PictureDto toDto(Picture picture);
}
