package ru.vasilenko.dictionary.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Create/update data")
@Data
public class CreateUpdateDataDto {

    @Schema(example = "FRONTEND_DEVELOPER")
    private String code;

    @Schema(example = "Oleg")
    private String value;

    @Schema(example = "8bacaca0-a531-444d-8e92-5979a2d511ea")
    private String dictionaryId;
}
