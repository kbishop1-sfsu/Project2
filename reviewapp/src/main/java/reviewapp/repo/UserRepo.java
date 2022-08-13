package reviewapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reviewapp.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
