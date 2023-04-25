package kz.intertop.service;

import kz.intertop.dto.SeasonDto;
import kz.intertop.mapper.SeasonMapper;
import kz.intertop.models.item.Season;
import kz.intertop.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeasonService {
    private final SeasonRepository seasonRepository;
    private final SeasonMapper seasonMapper;
    private Map<Long, SeasonDto> seasonsDtoMap;
    private Map<Long, Season> seasonsMap;

    private List<Season> getAll() {
        return seasonRepository.findAll();
    }

    public List<SeasonDto> getAllDto() {
        return getAll().stream().map(seasonMapper::toDto).toList();
    }

    public Season getById(Long id) {
        return seasonsMap.get(id);
    }

    public SeasonDto getByIdDto(Long id) {
        return seasonsDtoMap.get(id);
    }


    @PostConstruct
    public void initSeasonMaps() {
        List<Season> allSeasons = getAll();
        seasonsDtoMap = allSeasons.stream().map(seasonMapper::toDto).collect(Collectors.toMap(SeasonDto::getId, Function.identity()));
        seasonsMap = allSeasons.stream().collect(Collectors.toMap(Season::getId, Function.identity()));
    }
}
