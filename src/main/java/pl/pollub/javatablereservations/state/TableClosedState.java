package pl.pollub.javatablereservations.state;

import pl.pollub.javatablereservations.entity.Table;

public class TableClosedState implements TableState {

    @Override
    public void handle(Table table) {
        System.out.println("Sending info to external system...");
    }
}
