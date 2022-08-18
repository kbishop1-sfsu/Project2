package project2.reviewapp.models;

//import lombok.Builder;

import javax.persistence.*;
import java.util.List;

//@Builder
@Entity
@Table(name="pages")
public class RestaurantPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="avg_rating")
    private float avgRating;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="restr_id", referencedColumnName = "id", unique = true)
    private Restaurant restaurant;
    //private List<Review> reviews;
    //private List<Reservation> reservations;

    public RestaurantPage(){}

    public RestaurantPage(int id, float avgRating, Restaurant restaurant) {
        this.id = id;
        this.avgRating = avgRating;
        this.restaurant = restaurant;
    }

    /*public RestaurantPage(int id, float avgRating, Restaurant restaurant, List<Review> reviews, List<Reservation> reservations) {
        this.id = id;
        this.avgRating = avgRating;
        this.restaurant = restaurant;
        this.reviews = reviews;
        this.reservations = reservations;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(float avgRating) {
        this.avgRating = avgRating;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

   /* public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }*/

    @Override
    public String toString() {
        return "RestaurantPage{" +
                "id=" + id +
                ", avgRating=" + avgRating +
                ", restaurant=" + restaurant +
                /*", reviews=" + reviews +
                ", reservations=" + reservations +*/
                '}';
    }
}
