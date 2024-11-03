package com.smartsimon.utils.erknm_helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.smartsimon.utils.erknm_helper.model.KnmRequirementsMandatoryRequirementPreviewDTO;
import com.smartsimon.utils.erknm_helper.model.KnmRequirementsPreviewDTO;
import com.smartsimon.utils.erknm_helper.model.KnmRequirementsStructuralUnitPreviewDTO;
import com.smartsimon.utils.erknm_helper.model.PmDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

@Component
public class Test {

    @Autowired
    private ObjectMapper objectMapper;
    private static int count = 0;

    public static void main(String[] args) throws IOException {

        String jsonData = readFileFromResources("test.txt");
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        PmDTO pm = objectMapper.readValue(jsonData, PmDTO.class);

        pm.getRequirements().forEach(req -> checkAvailable(req));
        System.out.println(count);
    }

    private static void checkAvailable(KnmRequirementsPreviewDTO req) {
        if (Objects.isNull(req.getStructuralUnit()) || CollectionUtils.isEmpty(req.getStructuralUnit().getMandatoryRequirements())) {
            System.out.printf("Requirement with id %d hasn't SU or MandatoryRequirements is empty", req.getNpaId());
            return;
        }
        req.getStructuralUnit().getMandatoryRequirements().stream()
                .filter(mandatoryReq -> isMandatoryNotFound(mandatoryReq))
                .forEach(mandatoryReq -> setNewMandatory(mandatoryReq.getId(), req.getStructuralUnit()));
    }

    private static void setNewMandatory(Long notExistingId, KnmRequirementsStructuralUnitPreviewDTO structuralUnit) {
//todo

    }

    private static boolean isMandatoryNotFound(KnmRequirementsMandatoryRequirementPreviewDTO mandatoryReq) {

        //todo:
        count++;
        return false;
    }

    public static String readFileFromResources(String fileName) throws IOException {
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
