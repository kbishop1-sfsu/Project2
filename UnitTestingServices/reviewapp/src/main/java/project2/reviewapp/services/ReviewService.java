package project2.reviewapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import project2.reviewapp.models.Review;
import project2.reviewapp.repos.ReviewRepository;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public List<Review> getAllReviews(){ //Finds all reviews
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(int id){ //Finds review by ID
        return reviewRepository.findById(id);
    }

    public Review saveReview(Review review){ //Saves Review
        return reviewRepository.save(review);
    }
}
