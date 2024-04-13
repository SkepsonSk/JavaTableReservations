package pl.pollub.javatablereservations.state;

import pl.pollub.javatablereservations.entity.Table;

public class TableReadyState implements TableState {
    @Override
    public void handle(Table table) {}
}
