package com.smartsimon.utils.erknm.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.smartsimon.utils.erknm.helper.entity.RotMandatoryRequirement;
import com.smartsimon.utils.erknm.helper.model.KnmRequirementsMandatoryRequirementPreviewDTO;
import com.smartsimon.utils.erknm.helper.model.KnmRequirementsPreviewDTO;
import com.smartsimon.utils.erknm.helper.model.KnmRequirementsStructuralUnitPreviewDTO;
import com.smartsimon.utils.erknm.helper.model.PmDTO;
import com.smartsimon.utils.erknm.helper.repository.RotMandatoryRequirementRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Optional;

@Log
@AllArgsConstructor
@Component
public class RequirementsHelperService {


    private RotMandatoryRequirementRepository rotMandatoryRequirementRepository;
    private ObjectMapper objectMapper;
    private static int count = 0;

    public void start() throws IOException {
        count = 0;
        String jsonData = readFileFromResources("input.txt");
        objectMapper.registerModule(new JavaTimeModule());
        PmDTO pm = objectMapper.readValue(jsonData, PmDTO.class);
        pm.getRequirements().forEach(req -> changeNonExisting(req));
        saveToFileResources(jsonData);
        System.out.println(String.format("processed %d requirements", count));
    }

    private void saveToFileResources(String jsonData) throws IOException {

        FileUtils.writeStringToFile(
                new File("output.json"),
                jsonData,
                StandardCharsets.UTF_8,
                false
        );

    }

    private void changeNonExisting(KnmRequirementsPreviewDTO req) {
        if (Objects.isNull(req.getStructuralUnit()) || CollectionUtils.isEmpty(req.getStructuralUnit().getMandatoryRequirements())) {
            log.info(String.format("Requirement with id %d hasn't SU or MandatoryRequirements is empty", req.getNpaId()));
            return;
        }
        req.getStructuralUnit().getMandatoryRequirements().stream()
                .filter(mandatoryReq -> isMandatoryNotFound(mandatoryReq))
                .forEach(mandatoryReq -> setNewMandatory(mandatoryReq.getId(), req.getStructuralUnit()));
    }

    private void setNewMandatory(Long notExistingId, KnmRequirementsStructuralUnitPreviewDTO structuralUnit) {
//todo
        log.info(String.format("%d", notExistingId));
    }

    private boolean isMandatoryNotFound(KnmRequirementsMandatoryRequirementPreviewDTO mandatoryReq) {
        Optional<RotMandatoryRequirement> entityOptional = rotMandatoryRequirementRepository.findById(mandatoryReq.getId());
        if (entityOptional.isEmpty()) {
            count++;
            return true;
        }
        log.info("Mandatory requirement with id " + entityOptional.get().getId() + " found");
        return false;
    }

    public String readFileFromResources(String fileName) throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:" + fileName);
        InputStream inputStream = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        reader.close();
        return stringBuilder.toString();
    }

}
