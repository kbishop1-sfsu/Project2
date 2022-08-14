package reviewapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import reviewapp.models.RestaurantPage;
import reviewapp.repo.RestaurantPageRepo;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestaurantPageService {
    @Autowired
    private RestaurantPageRepo restaurantPageRepo;

    @org.springframework.transaction.annotation.Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public List<RestaurantPage> getAllRestPages() { //Finds all pages
        return restaurantPageRepo.findAll();
    }

    public Optional<RestaurantPage> getRestPageById(int id){ //Finds page by id
        return restaurantPageRepo.findById(id);
    }

    public RestaurantPage saveRestPage(RestaurantPage restaurantPage){ //Saves page
        return restaurantPageRepo.save(restaurantPage);
    }
}
