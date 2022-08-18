package project2.reviewapp.models;

//import lombok.Builder;

import javax.persistence.*;
import java.sql.Timestamp;

//@Builder
@Entity
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
    @Column(name="posted")
    private Timestamp datePosted;
    @Column(name="rating")
    private int rating;
    @Column(name="descr")
    private String description;

    public Review() {
    }

    public Review(int id, User user, Timestamp datePosted, int rating, String description) {
        this.id = id;
        this.user = user;
        this.datePosted = datePosted;
        this.rating = rating;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Timestamp datePosted) {
        this.datePosted = datePosted;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", user=" + user +
                ", datePosted=" + datePosted +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}
