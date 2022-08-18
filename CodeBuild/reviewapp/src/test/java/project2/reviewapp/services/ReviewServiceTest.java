package project2.reviewapp.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import project2.reviewapp.models.Review;
import project2.reviewapp.models.User;
import project2.reviewapp.repos.ReviewRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;
    @Mock
    private ReviewService reviewService;
    private Review review;

    @BeforeEach
    public void init(){
        reviewRepository = Mockito.mock(ReviewRepository.class);
        reviewService = new ReviewService(reviewRepository);
        review = Review.builder()
                .id(1)
                .datePosted(new Timestamp(System.currentTimeMillis()))
                .rating(5)
                .user(new User(1,
                        "tom",
                        "cat",
                        "tom@gmail.com",
                        "username",
                        "password"))
                .description("Best Food Ever")
                .build();
    }

    @Test
    public void getAllReviewsList(){
        List<Review> reviewList = new ArrayList<>();
        reviewList.add(review);

        when(reviewService.getAllReviews()).thenReturn(reviewList);
        List<Review> reviews = reviewService.getAllReviews();

        assertThat(reviews).isNotNull();
        assertThat(reviews.size()).isEqualTo(1);
    }

    @Test
    public void getReviewById(){
        when(reviewService.getReviewById(1)).thenReturn(Optional.ofNullable(review));
        Optional<Review> reviews = reviewService.getReviewById(1);

        assertThat(reviews).isNotNull();
        assertThat(reviews.get().getId()).isEqualTo(1);
    }
}