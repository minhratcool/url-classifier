package com.peer39.homework.services;

import com.peer39.homework.config.Runner;
import com.peer39.homework.dto.ClassificationDTO;
import com.peer39.homework.models.Category;
import com.peer39.homework.models.CategoryKeyword;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@Log4j2
public class ClassificationServiceImpl implements ClassificationService{
    private String extractTextFromUrl(String url) throws IOException {
        // Using Jsoup library to read url text
        Document doc = Jsoup.connect(url).get();
        doc.select("script").remove();
        return doc.body().text();
    }

    private Map<String, String> extractTextFromUrls(List<String> urls) {
        final Map<String, String> result = new HashMap<>();
        try {
            urls.parallelStream()
                    .forEach(url -> {
                        try {
                            if (Objects.isNull(result.get(url)))
                                result.put(url, extractTextFromUrl(url));
                        } catch (Exception e) {
                            log.error("Error with: " + url + " - Error message: " + e.getMessage());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<String> classifyURL(String url, List<Category> categories, Map<String, String> urlTextMap) {
        List<String> matchingCategories = new ArrayList<>();
        String urlText = urlTextMap.get(url);
        if (urlText != null) {
            for (Category category : categories) {
                for (CategoryKeyword keyword : category.getKeywords()) {
                    if (urlText.toLowerCase().contains(keyword.getKeyword().toLowerCase())) {
                        matchingCategories.add(category.getName());
                        break; // We found a match, no need to continue searching for this category
                    }
                }
            }
        }
        return matchingCategories;
    }

    @Override
    public List<ClassificationDTO> classifyUrls(List<String> urls) {
        // Load pre-defined categories
        List<Category> categories = Runner.initializeModel();

        // Extract text from URLs
        Map<String, String> urlTextMap = extractTextFromUrls(urls);

        // Classify URLs for matching categories
        List<ClassificationDTO> results = new ArrayList<>();
        for (String url : urlTextMap.keySet()) {
            List<String> matchingCategories = classifyURL(url, categories, urlTextMap);
            results.add(new ClassificationDTO(url, matchingCategories));
        }

        return results;
    }
}
