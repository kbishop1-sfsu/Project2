package project2.reviewapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.reviewapp.models.Review;
import project2.reviewapp.services.ReviewService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Value("${server.port}")
    int serverPort;

    private ReviewService reviewService;
    private List<Review> reviews;

    @Autowired

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
        this.reviews = new ArrayList<>();
    }

    //Returns all reviews
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllReviews(){
        reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    //Saves a review
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createReview(@RequestBody Review newReview) throws URISyntaxException{
        reviews.add(newReview);
        reviewService.saveReview(newReview);
        return ResponseEntity.created(new URI("http://localhost:"+serverPort+"/reviewapp/reviews/"+newReview.getId())).build();
    }


}
