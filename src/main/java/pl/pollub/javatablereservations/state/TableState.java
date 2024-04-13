package pl.pollub.javatablereservations.state;

import pl.pollub.javatablereservations.entity.Table;

public interface TableState {

    void handle(Table table);

}
