package pl.pollub.javatablereservations.observer;

import pl.pollub.javatablereservations.entity.Table;

import java.util.ArrayList;
import java.util.List;

public class TableMonitor implements Subject<Table> {

    private static TableMonitor instance;
    public static TableMonitor getInstance() {
        if (instance == null) {
            instance = new TableMonitor();
        }
        return instance;
    }

    private final List<Observer<Table>> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer<Table> observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<Table> observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(Table data) {
        for (Observer<Table> observer : this.observers) {
            observer.update(data);
        }
    }
}
