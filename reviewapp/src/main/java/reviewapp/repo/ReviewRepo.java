package reviewapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reviewapp.models.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
