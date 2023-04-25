package kz.intertop.mapper;

import kz.intertop.dto.SeasonDto;
import kz.intertop.models.item.Season;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeasonMapper {
    Season toEntity(SeasonDto seasonDto);
    SeasonDto toDto(Season season);
}
