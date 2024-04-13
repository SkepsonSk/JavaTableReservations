package pl.pollub.javatablereservations.strategy;

import pl.pollub.javatablereservations.entity.Role;
import pl.pollub.javatablereservations.entity.User;

public class CreateUserStrategy implements UserAccessStrategy {

    @Override
    public Boolean determineAccess(User user) {
        Role role = user.getRole();
        return role.getName().equals("Admin");
    }

}
