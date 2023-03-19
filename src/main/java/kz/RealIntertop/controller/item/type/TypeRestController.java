package kz.RealIntertop.controller.item.type;

import kz.RealIntertop.dto.SubTypeDto;
import kz.RealIntertop.dto.SubTypeJSON;
import kz.RealIntertop.dto.TypeDto;
import kz.RealIntertop.service.SubTypeService;
import kz.RealIntertop.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
        return typeService.getById(id);
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
