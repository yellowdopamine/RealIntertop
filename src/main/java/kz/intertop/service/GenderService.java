package kz.intertop.service;

import kz.intertop.dto.GenderDto;
import kz.intertop.mapper.GenderMapper;
import kz.intertop.models.item.Gender;
import kz.intertop.repository.GenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenderService {
    private final GenderRepository genderRepository;
    private final GenderMapper genderMapper;
    private Map<Long, GenderDto> gendersDtoMap;
    private Map<Long, Gender> gendersMap;

    @PostConstruct
    public void initGendersMap() {
        gendersMap = getAll().stream().collect(Collectors.toMap(Gender::getId, Function.identity()));
        gendersDtoMap = getAllDto().stream().collect(Collectors.toMap(GenderDto::getId, Function.identity()));
    }

    public List<Gender> getAll(){
        return genderRepository.findAll();
    }

    public List<GenderDto> getAllDto() {
        return getAll().stream().map(genderMapper::toDto).toList();
    }

    public Gender getById(Long id) {
        return gendersMap.get(id);
    }
    public GenderDto getByIdDto(Long id) {
        return gendersDtoMap.get(id);
    }
}
