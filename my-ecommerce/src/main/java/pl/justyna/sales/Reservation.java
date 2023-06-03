package pl.justyna.sales;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Reservation {
    @Id
    private String reservationId;
    private BigDecimal total;
    private String paymentId;

    public Reservation() {}

    public Reservation(String reservationId, BigDecimal total, String paymentId) {
        this.reservationId = reservationId;
        this.total = total;
        this.paymentId = paymentId;
    }

    public static Reservation from(Offer offer) {
        return null;
    }


    public String getId() {
        return reservationId;
    }
}
