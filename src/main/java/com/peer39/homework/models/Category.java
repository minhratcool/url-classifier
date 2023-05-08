package com.peer39.homework.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class Category {
    private String name;
    private List<CategoryKeyword> keywords;


}
