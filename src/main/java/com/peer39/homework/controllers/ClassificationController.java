package com.peer39.homework.controllers;

import com.peer39.homework.dto.ClassificationDTO;
import com.peer39.homework.dto.ResponseDTO;
import com.peer39.homework.services.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classify")
public class ClassificationController {

    private final ClassificationService classificationService;

    @Autowired
    public ClassificationController(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<ClassificationDTO>> classifyUrls(@RequestBody List<String> urls) {
        try {
            List<ClassificationDTO> matchedCategories = classificationService.classifyUrls(urls);
            ResponseDTO<ClassificationDTO> responseDTO = new ResponseDTO<>();
            responseDTO.setResult(matchedCategories);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO<ClassificationDTO> responseDTO = new ResponseDTO<>();
            responseDTO.setError(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            return ResponseEntity.ok(responseDTO);
        }

    }
}

