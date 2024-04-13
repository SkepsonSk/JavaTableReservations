package pl.pollub.javatablereservations.mediator;

import pl.pollub.javatablereservations.entity.User;

public interface UserMediator {

    Boolean mediateAccess(User user, String action);

}
