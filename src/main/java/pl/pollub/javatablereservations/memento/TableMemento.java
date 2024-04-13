package pl.pollub.javatablereservations.memento;

import java.util.UUID;

public class TableMemento {

    private final UUID id;
    private final int seats;
    private final UUID status;

    public TableMemento(UUID id, int seats, UUID status) {
        this.id = id;
        this.seats = seats;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public int getSeats() {
        return seats;
    }

    public UUID getStatus() {
        return status;
    }
}
