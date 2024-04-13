package pl.pollub.javatablereservations.memento;

import java.util.*;

public class TableHistory {

    private static TableHistory instance;

    public static TableHistory getInstance() {
        if (instance == null){
            instance = new TableHistory();
        }
        return instance;
    }

    private final List<List<TableMemento>> mementoList;

    public TableHistory() {
        this.mementoList = new ArrayList<>();
    }

    public void addMemento(List<TableMemento> mementoList) {
        this.mementoList.add(mementoList);
    }

    public List<TableMemento> getMementos(int index) {
        return this.mementoList.get(index);
    }
}
