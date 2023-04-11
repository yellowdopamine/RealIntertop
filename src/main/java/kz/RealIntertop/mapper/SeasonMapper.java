package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.SeasonDto;
import kz.RealIntertop.models.item.Season;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeasonMapper {
    Season toEntity(SeasonDto seasonDto);
    SeasonDto toDto(Season season);
}
