package reviewapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reviewapp.models.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {
}
