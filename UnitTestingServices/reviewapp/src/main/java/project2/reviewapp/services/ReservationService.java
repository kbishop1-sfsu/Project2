package project2.reviewapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import project2.reviewapp.models.Reservation;
import project2.reviewapp.repos.ReservationRepository;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public List<Reservation> getAllReservations(){ //Finds all Reservations
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(int id){ //Finds reservation by ID
        return reservationRepository.findById(id);
    }

    public Reservation saveReservation(Reservation reservation){ //Saves Reservation
        return reservationRepository.save(reservation);
    }

}
