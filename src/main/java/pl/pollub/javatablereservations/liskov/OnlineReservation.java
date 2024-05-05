package pl.pollub.javatablereservations.liskov;
import java.util.Date;

public class OnlineReservation extends Reservation {

    private final String confirmationEmail;

    public OnlineReservation(String customerName, Date reservationDate, String confirmationEmail) {
        super(customerName, reservationDate);
        this.confirmationEmail = confirmationEmail;
    }

    @Override
    public void confirmReservation() {
        super.confirmReservation();
        System.out.println("Confirmation sent to email: " + confirmationEmail);
    }
}


