package co2103.hw1;

import co2103.hw1.domain.Chef;
import co2103.hw1.domain.Restaurant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Hw1Application implements CommandLineRunner {

    public static List<Restaurant> restaurants;

    public static void main(String[] args) {
        SpringApplication.run(Hw1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Chef> chefs = new ArrayList<>();
        Chef chef1 = new Chef();
        chef1.setName("Bobo");
        chef1.setNationality("Nigerian");
        chef1.setSpeciality("Desserts");
        chef1.setStars(4);
        chefs.add(chef1);

        Chef chef2 = new Chef();
        chef2.setName("Beejay");
        chef2.setNationality("British");
        chef2.setSpeciality("Mains");
        chef2.setStars(5);
        chefs.add(chef2);

        restaurants = new ArrayList<>();
        Restaurant r = new Restaurant();
        r.setId(20);
        r.setName("WALEXIS CUISINE");
        r.setOwner("DULEX");
        r.setChefs(chefs);
        restaurants.add(r);
    }


}