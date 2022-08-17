package project2.reviewapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import project2.reviewapp.models.Restaurant;
import project2.reviewapp.repos.RestaurantRepository;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public List<Restaurant> getAllRestaurants(){ //Finds all Restaurants
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(int id){ //Gets restaurant by ID
        return restaurantRepository.findById(id);
    }

    public Restaurant saveRestaurant(Restaurant restaurant){ //Saves Restaurant
        return restaurantRepository.save(restaurant);
    }
}
