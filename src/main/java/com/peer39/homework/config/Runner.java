package com.peer39.homework.config;

import com.peer39.homework.models.Category;
import com.peer39.homework.models.CategoryKeyword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static List<Category> initializeModel() {
        // Star Wars category and keywords
        Category starWars = new Category();
        starWars.setName("Star Wars");
        List<CategoryKeyword> starWarsKeywords = new ArrayList<>();
        starWarsKeywords.add(new CategoryKeyword("star war"));
        starWarsKeywords.add(new CategoryKeyword("starwars"));
        starWarsKeywords.add(new CategoryKeyword("starwar"));
        starWarsKeywords.add(new CategoryKeyword("star wars"));
        starWarsKeywords.add(new CategoryKeyword("may the force be with you"));
        starWarsKeywords.add(new CategoryKeyword("r2d2"));
        starWars.setKeywords(starWarsKeywords);

        // Basketball category and keywords
        Category basketball = new Category();
        basketball.setName("Basketball");
        List<CategoryKeyword> basketballKeywords = new ArrayList<>();
        basketballKeywords.add(new CategoryKeyword("basketball"));
        basketballKeywords.add(new CategoryKeyword("nba"));
        basketballKeywords.add(new CategoryKeyword("ncaa"));
        basketballKeywords.add(new CategoryKeyword("lebron james"));
        basketballKeywords.add(new CategoryKeyword("john stokton"));
        basketballKeywords.add(new CategoryKeyword("anthony davis"));
        basketball.setKeywords(basketballKeywords);

        // Save the categories to memory or database for later use
        return Arrays.asList(starWars, basketball);
    }
}
