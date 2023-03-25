package kz.RealIntertop.service;

import kz.RealIntertop.dto.SeasonDto;
import kz.RealIntertop.mapper.SeasonMapper;
import kz.RealIntertop.model.item.Season;
import kz.RealIntertop.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeasonService {
    private final SeasonRepository seasonRepository;
    private final SeasonMapper seasonMapper;

    public List<SeasonDto> getAllDto(){
        return seasonRepository.findAll().stream().map(seasonMapper::toDto).collect(Collectors.toList());
    }

    public List<Season> getAll(){
        return seasonRepository.findAll();
    }
    public SeasonDto getById(Long id){
        return seasonMapper.toDto(seasonRepository.findSeasonById(id));
    }
}
