package project2.reviewapp.models;

import javax.persistence.*;

@Entity
@Table(name="admins")
public class Admin extends User{
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="page_id", referencedColumnName="id")
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
                "id=" + super.getId() +
                ", firstname='" + super.getFirstname() + '\'' +
                ", lastname='" + super.getLastname() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", username='" + super.getUsername() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                "assocRestaurant=" + assocRestaurant + '\'' +
                '}';
    }
}
