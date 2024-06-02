package pl.pollub.javatablereservations.dto;

import java.util.UUID;

public class UpdateTableDto {

    private UUID id;
    private int seats;
    private UUID status;

    public UUID getId() {
        return id;
    }

    public int getSeats() {
        return seats;
    }

    public UUID getStatus() {
        return status;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setStatus(UUID status) {
        this.status = status;
    }
}
