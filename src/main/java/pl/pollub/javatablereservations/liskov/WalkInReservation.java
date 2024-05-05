package pl.pollub.javatablereservations.liskov;
import java.util.Date;

public class WalkInReservation extends Reservation {

    public WalkInReservation(String customerName, Date reservationDate) {
        super(customerName, reservationDate);
    }

    @Override
    public void confirmReservation() {
        System.out.println("Please proceed to the waiting area for reservation waiting and approval");
    }
}
