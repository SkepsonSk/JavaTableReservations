package pl.pollub.javatablereservations.interfaceSegregation.reservation;

import java.util.Date;
import java.util.UUID;

//Before interface segregation
public interface ReservationOperations {
    void makeReservation(UUID tableId, Date date);
    void cancelReservation(UUID reservationId);
    void modifyReservation(UUID reservationId, UUID tableId, Date date);
    void confirmReservation(String emailAddress);
}