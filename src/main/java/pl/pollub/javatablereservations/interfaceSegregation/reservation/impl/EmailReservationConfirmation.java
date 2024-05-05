package pl.pollub.javatablereservations.interfaceSegregation.reservation.impl;

import pl.pollub.javatablereservations.interfaceSegregation.reservation.ReservationConfirmation;

public class EmailReservationConfirmation implements ReservationConfirmation {

    @Override
    public void confirmReservation(String emailAddress) {
        System.out.printf("Sending reservation confirmation to %s", emailAddress);
    }
}
