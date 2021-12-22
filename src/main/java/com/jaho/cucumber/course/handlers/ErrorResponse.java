package com.jaho.cucumber.course.handlers;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<String> details;
}