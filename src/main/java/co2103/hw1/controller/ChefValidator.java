package co2103.hw1.controller;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Chef;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Set;


public class ChefValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Chef.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Chef chef = (Chef) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nationality", "NotEmpty");

        if (!isValidSpeciality(chef.getSpeciality())) {
            errors.rejectValue("speciality", " ", "Invalid.Chef.Speciality");
        }

        if (chef.getStars() < 1 || chef.getStars() > 3) {
            errors.rejectValue("stars", " ", "Invalid.chef.stars");

        }


    }

    private boolean isValidSpeciality(String speciality) {
        return speciality.equals("Starters") || speciality.equals("Mains") || speciality.equals("Desserts");
    }
}

