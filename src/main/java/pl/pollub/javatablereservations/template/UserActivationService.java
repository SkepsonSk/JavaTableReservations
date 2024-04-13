package pl.pollub.javatablereservations.template;

import pl.pollub.javatablereservations.entity.User;

public abstract class UserActivationService {

    public User activateUser() {
        User user = this.createUser();
        this.notifyUser(user);
        return user;
    }

    public abstract User createUser();
    public abstract void notifyUser(User user);

}
