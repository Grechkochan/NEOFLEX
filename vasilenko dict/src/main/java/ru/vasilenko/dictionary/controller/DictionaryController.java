package ru.vasilenko.dictionary.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vasilenko.dictionary.dto.CreateUpdateDictionaryDto;
import ru.vasilenko.dictionary.dto.DictionaryDto;
import ru.vasilenko.dictionary.service.DictionaryService;

@Tag(name = "Dictionary controller", description = "Creation and updating dictionary")
@RestController
@RequestMapping("/dictionary")
@RequiredArgsConstructor
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @Operation(summary = "Create new dictionary")
    @PostMapping
    public DictionaryDto createDictionary(@RequestBody @Parameter(description = "Params for dictionary node")CreateUpdateDictionaryDto createUpdateDictionaryDto){
        return dictionaryService.createDictionary(createUpdateDictionaryDto);
    }

    @Operation(summary = "Get dictionary by id with data list")
    @GetMapping(value = "/{id}")
    public DictionaryDto getDictionary (@PathVariable @Parameter(description = "Dictionary id") String id){
        return dictionaryService.getDictionaryDtoById(id);
    }
}
