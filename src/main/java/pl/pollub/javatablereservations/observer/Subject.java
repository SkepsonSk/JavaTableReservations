package pl.pollub.javatablereservations.observer;

public interface Subject<T> {

    void addObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);
    void notifyObservers(T data);

}
