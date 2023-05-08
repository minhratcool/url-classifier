package com.peer39.homework.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ResponseDTO<D> {
    private List<D> result;
    private String error;
}
