package reviewapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reviewapp.models.Reservation;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {
}
