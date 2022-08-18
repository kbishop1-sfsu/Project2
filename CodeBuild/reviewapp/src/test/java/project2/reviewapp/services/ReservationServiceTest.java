package project2.reviewapp.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import project2.reviewapp.models.Location;
import project2.reviewapp.models.Reservation;
import project2.reviewapp.models.Restaurant;
import project2.reviewapp.models.User;
import project2.reviewapp.repos.ReservationRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;
    @Mock
    private ReservationService reservationService;
    private Reservation reservation;

    @BeforeEach
    public void init(){
        reservationRepository = Mockito.mock(ReservationRepository.class);
        reservationService = new ReservationService(reservationRepository);
        reservation = Reservation.builder()
                .id(1)
                .reservationDate(new Timestamp(System.currentTimeMillis()))
                .restaurant(new Restaurant(1,
                        "Fries",
                        new Location(1,
                                "123 west way",
                                "blue town",
                                "California",
                                12345),
                        "Fried food",
                        "www.fries.com",
                        4f))
                .user(new User(1,
                        "tom",
                        "cat",
                        "tom@gmail.com",
                        "username",
                        "password"))
                .build();
    }

    @Test
    public void getAllReservationsList(){
        List<Reservation> reservationList = new ArrayList<>();
        reservationList.add(reservation);

        when(reservationService.getAllReservations()).thenReturn(reservationList);
        List<Reservation> reservations = reservationService.getAllReservations();

        assertThat(reservations).isNotNull();
        assertThat(reservations.size()).isEqualTo(1);
    }

    @Test
    public void getReservationsById(){
        when(reservationService.getReservationById(1)).thenReturn(Optional.ofNullable(reservation));
        Optional<Reservation> reservations = reservationService.getReservationById(1);

        assertThat(reservations).isNotNull();
        assertThat(reservations.get().getId()).isEqualTo(1);
    }

}