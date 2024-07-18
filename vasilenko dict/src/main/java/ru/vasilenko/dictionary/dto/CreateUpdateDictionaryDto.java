package ru.vasilenko.dictionary.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Params for creating/updating dictionary")
@Data
public class CreateUpdateDictionaryDto {

    @Schema(example = "VEGETABLE_DICTIONARY")
    private String code;

    @Schema(example = "All of simple vegetables")
    private String description;

}
