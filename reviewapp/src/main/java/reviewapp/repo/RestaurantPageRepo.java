package reviewapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reviewapp.models.RestaurantPage;

@Repository
public interface RestaurantPageRepo extends JpaRepository<RestaurantPage, Integer> {
}
