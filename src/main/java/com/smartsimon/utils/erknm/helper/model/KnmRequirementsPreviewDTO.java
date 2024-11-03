package com.smartsimon.utils.erknm.helper.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author SmartSimon
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные обязательных требований, подлежащих проверке")
public class KnmRequirementsPreviewDTO {

    @Schema(description = "Идентификатор НПА, содержащего обязательные требования")
    private Long npaId;

    @Schema(description = "Номер НПА")
    private String number;

    @Schema(description = "Название НПА")
    private String title;

    @Schema(description = "Дата утверждения НПА")
    private LocalDate acceptanceDate;

    @Schema(description = "Структурная единица НПА")
    private KnmRequirementsStructuralUnitPreviewDTO structuralUnit;
}
