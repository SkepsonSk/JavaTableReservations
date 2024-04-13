package pl.pollub.javatablereservations.iterator;

import pl.pollub.javatablereservations.entity.User;

import java.util.List;
import java.util.NoSuchElementException;

public class UserIterator implements Iterator<User> {

    private int currentIndex = 0;
    private final List<User> users;

    public UserIterator(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < users.size();
    }

    @Override
    public User next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return users.get(currentIndex++);
    }
}
