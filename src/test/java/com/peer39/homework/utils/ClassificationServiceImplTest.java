package com.peer39.homework.utils;

import com.peer39.homework.dto.ClassificationDTO;
import com.peer39.homework.services.ClassificationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class ClassificationServiceImplTest {
    @Autowired
    ClassificationService classificationService;

    @Test
    public void testExtractTextFromUrls() {
        List<String> urls = new ArrayList<>();
        urls.add("https://www.example.com");
        urls.add("https://www.google.com");
        urls.add("https://www.github.com");
        List<ClassificationDTO> result = classificationService.classifyUrls(urls);
        assertEquals(result.size(), 3);
        assertTrue(result.stream().map(ClassificationDTO::getUrl).collect(Collectors.toList()).containsAll(urls));
    }

    @Test
    public void testExtractTextFromUrlsWithInvalidUrls() {
        List<String> urls = new ArrayList<>();
        urls.add("https://www.example.com");
        urls.add("invalid_url");
        urls.add("https://www.github.com");
        List<ClassificationDTO> result = classificationService.classifyUrls(urls);
        assertEquals(result.size(), 2);
        assertTrue(result.stream().map(ClassificationDTO::getUrl).collect(Collectors.toList()).containsAll(List.of("https://www.example.com", "https://www.github.com")));
    }
}