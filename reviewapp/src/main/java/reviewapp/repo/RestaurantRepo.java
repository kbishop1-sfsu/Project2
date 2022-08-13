package reviewapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reviewapp.models.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
}
