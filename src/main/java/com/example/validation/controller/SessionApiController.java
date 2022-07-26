package com.example.validation.controller;

import com.example.validation.controller.dto.SessionCreationRequestDto;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SessionApiController {

    @GetMapping("/sessions")
    public String getSessions() {
        return "ok";
    }

    @PostMapping("/sessions/create")
    public String createSession(@Valid @RequestBody SessionCreationRequestDto sessionCreationRequestDto, BindingResult bindingResult) throws BindException {

        validateSessionOption(sessionCreationRequestDto.getCodeEnabled(), sessionCreationRequestDto.getBinaryEnabled(), sessionCreationRequestDto.getDependencyEnabled(), bindingResult);

        return "ok";
    }



    private void validateSessionOption(Boolean codeEnabled, Boolean binaryEnabled, Boolean dependencyEnabled, BindingResult bindingResult) throws BindException {
        if (!codeEnabled && !binaryEnabled && !dependencyEnabled) {
            bindingResult.rejectValue("codeEnabled", "Required");
            bindingResult.rejectValue("binaryEnabled", "Required");
            bindingResult.rejectValue("dependencyEnabled", "Required");
            throw new BindException(bindingResult);
        }
    }
}
