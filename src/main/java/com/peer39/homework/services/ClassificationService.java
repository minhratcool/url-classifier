package com.peer39.homework.services;

import com.peer39.homework.dto.ClassificationDTO;
import com.peer39.homework.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClassificationService {

    public List<ClassificationDTO> classifyUrls(List<String> urls);
}
