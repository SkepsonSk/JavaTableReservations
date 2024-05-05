package pl.pollub.javatablereservations.dependencyInversion.implementationClasses;

import pl.pollub.javatablereservations.dependencyInversion.abstractClasses.BaseReservationService;
import pl.pollub.javatablereservations.liskov.PhoneReservation;
import pl.pollub.javatablereservations.liskov.Reservation;

import java.util.Date;
import java.util.UUID;

public class PhoneReservationService extends BaseReservationService {

    private final String customerPhone;

    public PhoneReservationService(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Override
    public Reservation makeReservation(UUID tableId, String customerName) {
        return new PhoneReservation(customerName, new Date(), customerPhone);
    }
}
