package com.peer39.homework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class ClassificationDTO {
    private String url;
    private List<String> categories;
}
