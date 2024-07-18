package ru.vasilenko.dictionary.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Params of data entity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataDto {

    @Schema(description = "Id of current data", example = "24217c92-ecbe-479c-a998-cd33e8ec636d")
    private String id;

    @Schema(description = "Id of parent dictionary", example = "8bacaca0-a531-444d-8e92-5979a2d511ea")
    private String dictionary_id;

    @Schema(description = "Code of current data", example = "FRONTEND_DEVELOPER")
    private String code;

    @Schema(description = "Value of current data", example = "Oleg")
    private String value;
}
