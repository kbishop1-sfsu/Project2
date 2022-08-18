package project2.reviewapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import project2.reviewapp.models.RestaurantPage;
import project2.reviewapp.repos.RestaurantPageRepository;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestaurantPageService {
    @Autowired
    private RestaurantPageRepository restaurantPageRepository;

    public RestaurantPageService(RestaurantPageRepository restaurantPageRepo) {
        this.restaurantPageRepository = restaurantPageRepo;
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public List<RestaurantPage> getAllRestPages() { //Finds all pages
        return restaurantPageRepository.findAll();
    }

    public Optional<RestaurantPage> getRestPageById(int id){ //Finds page by id
        return restaurantPageRepository.findById(id);
    }

    public RestaurantPage saveRestPage(RestaurantPage restaurantPage){ //Saves page
        return restaurantPageRepository.save(restaurantPage);
    }
}
