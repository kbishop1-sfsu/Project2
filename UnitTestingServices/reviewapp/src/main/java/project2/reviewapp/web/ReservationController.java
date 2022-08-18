package project2.reviewapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.reviewapp.models.Reservation;
import project2.reviewapp.models.User;
import project2.reviewapp.repos.ReservationRepository;
import project2.reviewapp.repos.UserRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("reservations")
public class ReservationController {
    @Value("${server.port}")
    int serverPort;

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllReservations(){
        List<Reservation> allReservations = reservationRepository.findAll();
        return ResponseEntity.ok(allReservations);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createReservation(@RequestBody Reservation newReservation) throws URISyntaxException {
        reservationRepository.save(newReservation);
        return ResponseEntity.created(new URI("http://localhost:"+serverPort+"/reviewapp/reservations/"+newReservation.getId())).build();
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity deleteReservation(@PathVariable("id") int id){
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if(reservation.isPresent()){
            reservationRepository.delete(reservation.get());
            return ResponseEntity.ok(reservation.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path ="{id}")
    public ResponseEntity editReservationDate(@PathVariable("id") int id, @RequestBody Reservation reservationDetails){
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if(reservation.isPresent()){
            reservation.get().setReservationDate(reservationDetails.getReservationDate());
            reservation.get().setNumOfPeople(reservationDetails.getNumOfPeople());
            return ResponseEntity.ok(reservation.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path="{id}")
    public ResponseEntity getReservationById(@PathVariable("id") int id){
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if(reservation.isPresent()){
            return ResponseEntity.ok(reservation.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path="s/email", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getReservationByUser(@RequestParam(required = false) String email){
        List <Reservation> userReservations = reservationRepository.findAll().stream().filter(r -> r.getUser().getEmail().equals(email)).collect(Collectors.toList());
        return ResponseEntity.ok(userReservations);
    }

    @GetMapping(path="s/restaurant", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getReservationByRestaurant(@RequestParam(required = false)String restaurantName){
        List <Reservation> userReservations = reservationRepository.findAll().stream().filter(r -> r.getRestaurant().getRestaurantName().equals(restaurantName)).collect(Collectors.toList());
        return ResponseEntity.ok(userReservations);
    }






}
