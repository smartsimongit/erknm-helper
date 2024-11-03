package com.smartsimon.utils.erknm_helper.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author SmartSimon
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Данные структурных единиц обязательных требований")
public class KnmRequirementsStructuralUnitPreviewDTO {

    @Schema(description = "Идентификатор структурной единицы НПА")
    private Long id;

    @Schema(description = "Значение структурной единицы НПА")
    private String title;

    @Schema(description = "Формулировки обязательных требований")
    private List<KnmRequirementsMandatoryRequirementPreviewDTO> mandatoryRequirements;
}

