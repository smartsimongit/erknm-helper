package com.smartsimon.utils.erknm_helper.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SmartSimon
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные формулировки обязательных требований")
public class KnmRequirementsMandatoryRequirementPreviewDTO {

    @Schema(description = "Идентификатор формулировки обязательных требований")
    private Long id;

    @Schema(description = "Значение формулировки обязательных требований")
    private String title;
}
