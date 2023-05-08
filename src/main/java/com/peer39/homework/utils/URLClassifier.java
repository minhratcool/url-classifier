package com.peer39.homework.utils;

import com.peer39.homework.models.Category;
import com.peer39.homework.models.CategoryKeyword;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class URLClassifier {
    public static List<String> classifyURL(String url, List<Category> categories, Map<String, String> urlTextMap) {
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
}
