package pl.pollub.javatablereservations.dto;

import java.util.UUID;

public class NewTableDto {

    private int seats;
    private UUID status;

    public int getSeats() {
        return seats;
    }

    public UUID getStatus() {
        return status;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setStatus(UUID status) {
        this.status = status;
    }
}
