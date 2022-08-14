package reviewapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reviewapp.models.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
}
