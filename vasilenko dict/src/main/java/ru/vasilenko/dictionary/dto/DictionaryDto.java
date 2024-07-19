package ru.vasilenko.dictionary.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Schema(description = "Params for dictionary entity")
@Data
public class DictionaryDto {

    @Schema(description = "Id of current dictionary", example =  "8bacaca0-a531-444d-8e92-5979a2d511ea")
    private UUID id;

    @Schema(description = "Code of current dictionary", example = "VEGETABLE_DICTIONARY")
    private String code;

    @Schema(description = "Description", example = "All of simple vegetables")
    private String description;

}
