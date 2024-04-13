package pl.pollub.javatablereservations.visitor;

public interface SynchronizationItem {

    void accept(SynchronizationVisitor visitor);

}
