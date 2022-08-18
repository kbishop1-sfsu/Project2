package project2.reviewapp.models;

import lombok.Builder;
import javax.persistence.*;

@Builder
@Entity
@Table(name="restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="restr_name")
    private String restaurantName;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="loc", referencedColumnName = "id", unique = true)
    private Location location;//should be one restaurant to many loc?

    @Column(name="category")
    private String foodCategory;

    @Column(name="website")
    private String website;
    @Column(name="avg_rating")
    private float rating;

    public Restaurant() {
    }

    public Restaurant(int id, String restaurantName, Location location, String foodCategory, String website, float rating) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.location = location;
        this.foodCategory = foodCategory;
        this.website = website;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", restaurantName='" + restaurantName + '\'' +
                ", location=" + location +
                ", foodCategory='" + foodCategory + '\'' +
                ", website='" + website + '\'' +
                ", rating='" +  rating + '\'' +
                '}';
    }
}
