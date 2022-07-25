package com.example.validation.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class SessionCreationDto {

    @NotBlank
    private String sessionName;

    @NotNull
    @Size(min = 0, max = 50)
    private String sessionDescription;

    @NotEmpty
    private List<String> sessionManagers;

    @NotNull
    private Boolean codeEnabled;

    @NotNull
    private Boolean binaryEnabled;

    @NotNull
    private Boolean dependencyEnabled;
}
