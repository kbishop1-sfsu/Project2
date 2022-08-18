package project2.reviewapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project2.reviewapp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //TODO: getId()

    @Query(value = "select u from User u where u.email = :email")
    User findByEmail(@Param("email")String email);

    //TODO: updateUser
}
