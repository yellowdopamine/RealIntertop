package kz.intertop.controller.item.type;

import kz.intertop.dto.TypeDto;
import kz.intertop.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/type")
public class TypeRestController {
    private final TypeService typeService;
    @PostMapping()
    public TypeDto create(@RequestBody TypeDto typeDto) {
        return typeService.create(typeDto);
    }
    @GetMapping("/{id}")
    public TypeDto getById(@PathVariable Long id) {
        return typeService.getByIdDto(id);
    }
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @PutMapping()
    public TypeDto update(@RequestBody TypeDto typeDto) {
        return typeService.update(typeDto);
    }
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        typeService.deleteById(id);
    }
    @GetMapping("/all")
    public List<TypeDto> getAll() {
        return typeService.getAllDto();
    }
}
