package kz.intertop.mapper;

import kz.intertop.dto.GenderDto;
import kz.intertop.models.item.Gender;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenderMapper {
    Gender toEntity(GenderDto genderDto);
    GenderDto toDto(Gender gender);
}
