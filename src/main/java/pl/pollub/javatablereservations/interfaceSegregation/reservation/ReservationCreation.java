package pl.pollub.javatablereservations.interfaceSegregation.reservation;


import java.util.Date;
import java.util.UUID;

//after interface segregation
public interface ReservationCreation {
    void makeReservation(UUID tableId, Date date);
}

