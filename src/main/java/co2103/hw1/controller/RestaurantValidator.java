package co2103.hw1.controller;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Restaurant;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RestaurantValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Restaurant.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Restaurant restaurant = (Restaurant) target;
        if (isIdNotUnique(restaurant.getId())) {
            errors.rejectValue("restaurant", " ", "ID already in use.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", " ", "NotEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owner", " ", "NotEmpty");
    }

    private boolean isIdNotUnique(int id) {
        for (Restaurant r : Hw1Application.restaurants) {
            if (r.getId() == id) {
                return true;
            }

        }
        return false;
    }
}
