package co2103.hw1.controller;


import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Chef;
import co2103.hw1.domain.Restaurant;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import java.util.List;

@Controller
public class ChefController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new ChefValidator());
    }



    @GetMapping("/chefs")
    public String chefs( @RequestParam("restaurant") int RestaurantId, Model model) {

        Restaurant restaurants = new Restaurant();
        for (Restaurant r : Hw1Application.restaurants) {
            if (r.getId() == RestaurantId) {
                restaurants = r;
            }
        }

        List<Chef> chefs = restaurants.getChefs();
        model.addAttribute("chefs", chefs);
        model.addAttribute("restaurant", RestaurantId);
        return "chefs/list";
    }


    @RequestMapping("/newChef")
    public String newChef(@RequestParam("restaurant") int restaurant, Model model) {

        Restaurant restaurants = new Restaurant();
        for (Restaurant r: Hw1Application.restaurants) {
            if (r.getId() == restaurant) {
                restaurants = r;
            }
        }
        model.addAttribute("restaurant", restaurants.getId());
        model.addAttribute("chef",new Chef());
        return "chefs/form";
    }

    @PostMapping("/addChef")
    public String addChef(@Valid @ModelAttribute Chef chef, BindingResult result, @RequestParam("restaurant") int restaurantId,  Model model) {
        model.addAttribute("restaurant", restaurantId);
        if (result.hasErrors()) {
            return "chefs/form";
        }

        Restaurant restaurants = new Restaurant();
        for (Restaurant r : Hw1Application.restaurants) {
            if (r.getId() == restaurantId) {
                restaurants = r;
                break;
            }
        }
        List<Chef> chefs = restaurants.getChefs();
        restaurants.getChefs().add(chef);
        model.addAttribute("chefs", chefs);
        model.addAttribute("restaurants", restaurants);
        return "redirect:/restaurants";
    }
}
