package pl.pollub.javatablereservations.visitor;

import pl.pollub.javatablereservations.entity.Reservation;
import pl.pollub.javatablereservations.entity.Table;

public interface SynchronizationVisitor {

    void synchronize(Reservation table);
    void synchronize(Table reservation);

}
