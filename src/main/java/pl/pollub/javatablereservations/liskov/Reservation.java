package pl.pollub.javatablereservations.liskov;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {

    private final String customerName;
    private final Date reservationDate;

    public Reservation(String customerName, Date reservationDate) {
        this.customerName = customerName;
        this.reservationDate = reservationDate;
    }

    public void confirmReservation() {
        System.out.printf("Reservation confirmed for %s on %s", this.customerName, new SimpleDateFormat("yyyy-MM-dd").format(this.reservationDate));
    }
}
