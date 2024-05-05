package pl.pollub.javatablereservations.dependencyInversion.implementationClasses;
import pl.pollub.javatablereservations.dependencyInversion.abstractClasses.BaseReservationService;
import pl.pollub.javatablereservations.liskov.OnlineReservation;
import pl.pollub.javatablereservations.liskov.Reservation;

import java.util.Date;
import java.util.UUID;

public class OnlineReservationService extends BaseReservationService {

    private final String confirmationEmail;

    public OnlineReservationService(String confirmationEmail) {
        this.confirmationEmail = confirmationEmail;
    }

    @Override
    public Reservation makeReservation(UUID tableId, String customerName) {
        return new OnlineReservation(customerName, new Date(), this.confirmationEmail);
    }
}

