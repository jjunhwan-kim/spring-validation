package com.example.validation.controller.validation;

import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class SessionNameValidator implements ConstraintValidator<SessionNameUnique, String> {

    //private final SessionRepository sessionRepository;

    @Override
    public void initialize(SessionNameUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String sessionName, ConstraintValidatorContext context) {
        //return !sessionRepository.existsBySessionName(value);
        return !sessionName.equals("test");
    }
}
