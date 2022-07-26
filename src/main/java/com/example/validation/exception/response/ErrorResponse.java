package com.example.validation.exception.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Locale;

@Getter
@Builder
@RequiredArgsConstructor
public class ErrorResponse {

    private final String code;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<ValidationError> errors;

    @Getter
    @Builder
    @RequiredArgsConstructor
    public static class ValidationError {

        private final String field;
        private final String message;

        public static ValidationError of(final FieldError fieldError, MessageSource messageSource) {
            return ValidationError.builder()
                    .field(fieldError.getField())
                    .message(messageSource.getMessage(fieldError, Locale.getDefault()))
                    .build();
        }
    }
}
