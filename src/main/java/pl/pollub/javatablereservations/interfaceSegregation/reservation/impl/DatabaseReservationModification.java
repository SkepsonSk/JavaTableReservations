package pl.pollub.javatablereservations.interfaceSegregation.reservation.impl;

import pl.pollub.javatablereservations.interfaceSegregation.reservation.ReservationModification;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class DatabaseReservationModification implements ReservationModification {

    @Override
    public void cancelReservation(UUID reservationId) {
        System.out.printf("Cancelling reservation %s", reservationId);
    }

    @Override
    public void modifyReservation(UUID reservationId, UUID tableId, Date date) {
        System.out.printf("Modifying reservation: %s to: %s, %s",
                reservationId.toString(),
                tableId.toString(),
                new SimpleDateFormat("dd-MM-yyyy").format(date)
        );
    }
}
