package reviewapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reviewapp.models.Review;
import reviewapp.repo.ReviewRepo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public List<Review> getAllReviews(){ //Finds all reviews
        return reviewRepo.findAll();
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public Optional<Review> getReviewById(int id){ //Finds review by ID
        return reviewRepo.findById(id);
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public Review saveReview(Review review){ //Saves Review
        return reviewRepo.save(review);
    }
}
