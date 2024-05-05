package pl.pollub.javatablereservations.dependencyInversion.implementationClasses;

import pl.pollub.javatablereservations.dependencyInversion.abstractClasses.BaseReservationService;
import pl.pollub.javatablereservations.liskov.Reservation;
import pl.pollub.javatablereservations.liskov.WalkInReservation;

import java.util.Date;
import java.util.UUID;

public class WalkInReservationService extends BaseReservationService {

    @Override
    public Reservation makeReservation(UUID tableId, String customerName) {
        return new WalkInReservation(customerName, new Date());
    }
}
