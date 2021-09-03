package com.example.demo.domain.validation;

import com.example.demo.domain.Player;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PlayerValidation implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Player.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        validatePlayerInfo(target, errors);
        validateAnimalInfo(target, errors);
    }

    public void validateAnimalInfo(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "animal.name",
                "playerValidation.emptyAnimalName", "Empty animal name!");
        ValidationUtils.rejectIfEmpty(errors, "animal.animalType",
                "playerValidation.emptyAnimalType", "Empty animal type!");
    }

    public void validatePlayerInfo(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
                "playerValidation.emptyName", "Empty name!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age",
                "playerValidation.emptyAge", "Empty age!");
    }
}
