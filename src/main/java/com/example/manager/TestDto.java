package com.example.manager;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
public class TestDto {
    @Null
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private TestStatus status;
}
