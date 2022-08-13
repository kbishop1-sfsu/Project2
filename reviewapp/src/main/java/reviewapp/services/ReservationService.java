package reviewapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reviewapp.models.Reservation;
import reviewapp.repo.ReservationRepo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public List<Reservation> getAllReservations(){ //Finds all Reservations
        return reservationRepo.findAll();
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public Optional<Reservation> getReservationById(int id){ //Finds reservation by ID
        return reservationRepo.findById(id);
    }

}
