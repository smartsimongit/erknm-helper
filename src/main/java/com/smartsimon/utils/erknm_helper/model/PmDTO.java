package com.smartsimon.utils.erknm_helper.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Профилактическое мероприятие")
public class PmDTO {
    @Schema(description = "Ссылки на обязательные требования, подлежащие проверке")
    private List<KnmRequirementsPreviewDTO> requirements;
}
