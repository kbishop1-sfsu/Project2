package reviewapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reviewapp.models.Restaurant;
import reviewapp.repo.RestaurantRepo;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public List<Restaurant> getAllRestaurants(){ //Finds all Restaurants
        return restaurantRepo.findAll();
    }

    public Optional<Restaurant> getRestaurantById(int id){ //Gets restaurant by ID
        return restaurantRepo.findById(id);
    }

    public Restaurant saveRestaurant(Restaurant restaurant){ //Saves Restaurant
        return restaurantRepo.save(restaurant);
    }
}
