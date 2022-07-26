package com.example.validation.controller.dto;

import com.example.validation.controller.validation.SessionNameUnique;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class SessionCreationRequestDto {

    @NotBlank
    @SessionNameUnique
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
