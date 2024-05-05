package pl.pollub.javatablereservations.interfaceSegregation.reservation;

import java.util.Date;
import java.util.UUID;

public interface ReservationModification {
    void cancelReservation(UUID reservationId);

    void modifyReservation(UUID reservationId, UUID tableId, Date date);
}
