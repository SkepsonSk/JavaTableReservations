package pl.pollub.javatablereservations.dependencyInversion.abstractClasses;

import pl.pollub.javatablereservations.dependencyInversion.interfaces.ReservationService;
import pl.pollub.javatablereservations.liskov.Reservation;

import java.util.UUID;

public abstract class BaseReservationService implements ReservationService {
    public abstract Reservation makeReservation(UUID tableId, String customerName);
}
