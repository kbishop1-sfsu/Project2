package project2.reviewapp.models;

import javax.persistence.*;

@Entity
@Table(name="restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="restr_name")
    private String restaurantName;
    private Location location;
    @Column(name="category")
    private String foodCategory;
    @Column(name="website")
    private String website;

    public Restaurant() {
    }

    public Restaurant(int id, String restaurantName, Location location, String foodCategory, String website) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.location = location;
        this.foodCategory = foodCategory;
        this.website = website;
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

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", restaurantName='" + restaurantName + '\'' +
                ", location=" + location +
                ", foodCategory='" + foodCategory + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
