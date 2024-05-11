package co2103.hw1.controller;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Restaurant;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class RestaurantController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new RestaurantValidator());
    }
    @GetMapping("/restaurants")
    public String restaurants(Model model) {
        model.addAttribute("restaurants", Hw1Application.restaurants);
        return "restaurants/list";
    }

    @RequestMapping("/newrestaurants")
    public String newRestaurant(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "restaurants/form";
    }

    @PostMapping("addRestaurant")
    public String addRestaurant(@Valid @ModelAttribute Restaurant restaurant, BindingResult result ) {
        if (result.hasErrors()) {
            return "restaurants/form";
        }

        restaurant.setChefs(new ArrayList<>());
        Hw1Application.restaurants.add(restaurant);
        return "redirect:/restaurants";


    }
}
