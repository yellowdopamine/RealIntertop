package kz.RealIntertop.controller.item.type.subType;

import kz.RealIntertop.dto.SubTypeDto;
import kz.RealIntertop.service.SubTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/sub-type")
public class SubTypeRestController {
    private final SubTypeService subTypeService;

    @PostMapping()
    public SubTypeDto create(@RequestBody SubTypeDto subTypeDto) {
        return subTypeService.create(subTypeDto);
    }
    @GetMapping("/{id}")
    public SubTypeDto getById(@PathVariable Long id){
        return subTypeService.getById(id);
    }
    @GetMapping(value = "/get-by-type-id/{id}")
    public List<SubTypeDto> getByTypeId(@PathVariable Long id){
        return subTypeService.getByTypeId(id);
    }
    @PutMapping
    public SubTypeDto update(@RequestBody SubTypeDto subTypeDto){
        return subTypeService.update(subTypeDto);
    }
    @DeleteMapping()
    public void deleteSubType(@PathVariable Long id) {
        subTypeService.deleteById(id);
    }
    @GetMapping("/all")
    public List<SubTypeDto> getAll(){
        return subTypeService.getAll();
    }
}
