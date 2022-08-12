package project2.reviewapp.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admin extends User{
    private RestaurantPage assocRestaurant;

    public Admin() {}

    public Admin(int id, String firstname, String lastname, String email, String username, String password, RestaurantPage assocRestaurant) {
        super(id, firstname, lastname, email, username, password);
        this.assocRestaurant = assocRestaurant;
    }

    public RestaurantPage getAssocRestaurant() {
        return assocRestaurant;
    }

    public void setAssocRestaurant(RestaurantPage assocRestaurant) {
        this.assocRestaurant = assocRestaurant;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "assocRestaurant=" + assocRestaurant +
                '}';
    }
}
