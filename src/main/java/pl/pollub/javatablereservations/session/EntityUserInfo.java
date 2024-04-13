package pl.pollub.javatablereservations.session;

import pl.pollub.javatablereservations.entity.User;

import java.util.UUID;

public class EntityUserInfo implements UserInfo {

    private final User user;

    public EntityUserInfo(User user) {
        this.user = user;
    }

    @Override
    public UUID getUserId() {
        return user.getId();
    }

    @Override
    public String getName() {
        return String.format("%s %s", user.getFirstName(), user.getLastName());
    }
}
