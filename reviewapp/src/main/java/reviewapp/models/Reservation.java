package reviewapp.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="resv_date")
    private Timestamp reservationDate;
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="restr_id", referencedColumnName="id")
    private Restaurant restaurant;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
    @Column(name="status")
    private String status; //pending, confirmed, rejected

    public Reservation(){}

    public Reservation(int id, Timestamp reservationDate, Restaurant restaurant, User user, String status) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.restaurant = restaurant;
        this.user = user;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Timestamp reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationDate=" + reservationDate +
                ", restaurant=" + restaurant +
                ", user=" + user +
                ", status='" + status + '\'' +
                '}';
    }
}
