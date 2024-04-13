package pl.pollub.javatablereservations.observer;

import pl.pollub.javatablereservations.entity.Table;

import java.util.UUID;

public class TableObserver implements Observer<Table> {

    private final UUID tableId;

    public TableObserver(UUID tableId) {
        this.tableId = tableId;
    }

    @Override
    public void update(Table data) {
        if (data.getId().equals(this.tableId)) {
            System.out.println("Sending message to the client via SSE...");
        }
    }
}
