package pl.pollub.javatablereservations.interfaceSegregation.reservation.impl;

import pl.pollub.javatablereservations.interfaceSegregation.reservation.ReservationCreation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class DatabaseReservationCreation implements ReservationCreation {

    @Override
    public void makeReservation(UUID tableId, Date date) {
        System.out.printf("Making reservation: %s, %s",
                tableId.toString(),
                new SimpleDateFormat("dd-MM-yyyy").format(date)
        );
    }
}
