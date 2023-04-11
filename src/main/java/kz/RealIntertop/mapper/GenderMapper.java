package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.GenderDto;
import kz.RealIntertop.models.item.Gender;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenderMapper {
    Gender toEntity(GenderDto genderDto);
    GenderDto toDto(Gender gender);
}
