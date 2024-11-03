package com.smartsimon.utils.erknm.helper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@Tag(name = "Person REST API operations")
@RestController
@RequestMapping("/api/v1/erknm/helper")
@RequiredArgsConstructor
public class HelperController {
    private final RequirementsHelperService reqService;

    @Operation(
            summary = "replace non-existent requirements"
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void persons() throws IOException {
          reqService.start();
    }
}
