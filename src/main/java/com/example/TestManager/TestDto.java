package com.example.TestManager;

import lombok.Data;

@Data
public class TestDto {
    private Long id;
    private String name;
    private TestStatus status;
}
