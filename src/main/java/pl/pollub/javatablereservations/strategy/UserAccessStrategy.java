package pl.pollub.javatablereservations.strategy;

import pl.pollub.javatablereservations.entity.User;

public interface UserAccessStrategy {

    Boolean determineAccess(User user);

}
