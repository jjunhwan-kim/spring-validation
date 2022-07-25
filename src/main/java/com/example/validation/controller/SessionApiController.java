package com.example.validation.controller;

import com.example.validation.controller.dto.SessionCreationDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class SessionApiController {

    @GetMapping("/sessions")
    public String getSessions() {
        return "ok";
    }

    @PostMapping("/sessions/create")
    public String createSession(@Valid @RequestBody SessionCreationDto sessionCreationDto) {

        validateSessionName(sessionCreationDto.getSessionName());
        validateSessionManagers(sessionCreationDto.getSessionManagers());
        validateSessionOption(sessionCreationDto.getCodeEnabled(), sessionCreationDto.getBinaryEnabled(), sessionCreationDto.getDependencyEnabled());

        return "ok";
    }

    private void validateSessionName(String sessionName) {
        if (sessionName.equals("test")) {
            throw new IllegalArgumentException("Session name error");
        }
    }

    private void validateSessionManagers(List<String> sessionManagers) {
        Optional<String> admin = sessionManagers.stream()
                .filter(sessionManager -> sessionManager.equals("admin"))
                .findAny();
        if (!admin.isPresent()) {
            throw new IllegalArgumentException("Session manager error");
        }
    }

    private void validateSessionOption(Boolean codeEnabled, Boolean binaryEnabled, Boolean dependencyEnabled) {
        if (!codeEnabled && !binaryEnabled && !dependencyEnabled) {
            throw new IllegalArgumentException("Session option error");
        }
    }
}
