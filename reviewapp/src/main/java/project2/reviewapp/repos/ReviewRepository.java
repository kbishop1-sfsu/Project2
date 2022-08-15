package project2.reviewapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project2.reviewapp.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
