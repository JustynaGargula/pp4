package pl.justyna.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class ReservationStorageTest {

    //@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    ReservationRepository repository;

    @Test
    void insert(){
        Reservation reservation = new Reservation(
                "res-1234",
                BigDecimal.valueOf(10.10),
                "payu/12345"
        );
        repository.save(reservation);

        Reservation loaded = repository
                .findById("res-1234")
                .get();

        assert loaded.getId().equals(reservation.getId());
    }

    @Test
    void select(){

    }
}
