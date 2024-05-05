package pl.pollub.javatablereservations.liskov;
import java.util.Date;

public class PhoneReservation extends Reservation{

    private final String phoneNumber;

    public PhoneReservation(String customerName, Date reservationDate, String phoneNumber) {
        super(customerName, reservationDate);
        this.phoneNumber = phoneNumber;
    }
    @Override
    public void confirmReservation() {
        super.confirmReservation();
        System.out.printf("Customer phone number to contact is %s", this.phoneNumber);
    }
}
