package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.CollectionDto;
import kz.RealIntertop.dto.SeasonDto;
import kz.RealIntertop.model.item.Collection;
import kz.RealIntertop.model.item.Season;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeasonMapper {
    Season toEntity(SeasonDto seasonDto);
    SeasonDto toDto(Season season);
}
