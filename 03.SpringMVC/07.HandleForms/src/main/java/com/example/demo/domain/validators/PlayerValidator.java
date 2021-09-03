package com.example.demo.domain.validators;

import com.example.demo.domain.Player;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PlayerValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Player.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
                "player.nameRequired", "Ops for name!");
        ValidationUtils.rejectIfEmpty(errors, "age",
                "player.ageEmpty", "Ops for age!");
        ValidationUtils.rejectIfEmpty(errors, "pet.name",
                "player.petEmpty", "Ops for pet!");

        Player player = (Player) o;
        if (player.getSport().getId() != 1) {
            errors.reject("player.invalidSport", "Ops for sport!");
        }
    }
}
