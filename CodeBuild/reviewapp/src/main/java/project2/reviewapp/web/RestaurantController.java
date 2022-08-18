package project2.reviewapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.reviewapp.models.Restaurant;
import project2.reviewapp.services.RestaurantService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Value("${server.port}")
    int serverPort;

    private RestaurantService restaurantService;
    private List<Restaurant> restaurants;

    @Autowired
    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
        this.restaurants = new ArrayList<>();
    }

    //Gets all restaurants
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllRestaurants(){
        restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    //Gets Restaurant by given ID
    @GetMapping(path="{id}")
    public ResponseEntity getRestaurantById(@PathVariable int id){
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(id);
        if (restaurant.isPresent()){
            return ResponseEntity.ok(restaurant);
        }
        return ResponseEntity.notFound().build();
    }

    //Saves a restaurant
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createRestaurant(@RequestBody Restaurant newRestaurant) throws URISyntaxException{
        restaurants.add(newRestaurant);
        restaurantService.saveRestaurant(newRestaurant);
        return ResponseEntity.created(new URI("http:localhost:"+serverPort+"/reviewapp/restaurants/"+newRestaurant.getId())).build();
    }

}
