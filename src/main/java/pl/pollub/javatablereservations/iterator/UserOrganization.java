package pl.pollub.javatablereservations.iterator;

import pl.pollub.javatablereservations.entity.User;

import java.util.List;

public class UserOrganization implements Aggregate<User> {

    private final List<User> users;

    public UserOrganization(List<User> users) {
        this.users = users;
    }

    @Override
    public Iterator<User> createIterator() {
        return new UserIterator(users);
    }

}
