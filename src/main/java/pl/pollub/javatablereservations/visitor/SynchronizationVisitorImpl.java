package pl.pollub.javatablereservations.visitor;

import pl.pollub.javatablereservations.entity.Reservation;
import pl.pollub.javatablereservations.entity.Table;

public class SynchronizationVisitorImpl implements SynchronizationVisitor {

    @Override
    public void synchronize(Reservation reservation) {
        System.out.println("Synchronization of reservation...");
    }

    @Override
    public void synchronize(Table table) {
        System.out.println("Synchronization of table...");
    }
}
