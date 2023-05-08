package com.peer39.homework.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDTO<D> {
    private List<D> result;
    private String error;
}
