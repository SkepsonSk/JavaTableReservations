package pl.pollub.javatablereservations.dependencyInversion.interfaces;

import pl.pollub.javatablereservations.liskov.Reservation;

import java.util.UUID;

public interface ReservationService {

    Reservation makeReservation(UUID tableId, String customerName);
}
