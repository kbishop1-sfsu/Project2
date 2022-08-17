package project2.reviewapp.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name="users")
public class User {
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
    private int id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="username", unique = true)
    private String username;

    @Column(name="_password")
    private String password;

    public User() {
    }

    public User(int id, String firstname, String lastname, String email, String username, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
