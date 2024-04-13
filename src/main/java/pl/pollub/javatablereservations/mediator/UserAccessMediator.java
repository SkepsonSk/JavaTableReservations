package pl.pollub.javatablereservations.mediator;

import pl.pollub.javatablereservations.entity.Role;
import pl.pollub.javatablereservations.entity.User;

public class UserAccessMediator implements UserMediator {

    @Override
    public Boolean mediateAccess(User user, String action) {

        Role role = user.getRole();
        if (role.getName().equals("edit")) {
            return role.getName().equals("Admin") || role.getName().equals("Manager");
        } else if (role.getName().equals("create")) {
            return role.getName().equals("Admin");
        } else {
            return true;
        }

        //TODO implement strategy
    }
}
