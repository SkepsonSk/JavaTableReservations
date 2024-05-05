package pl.pollub.javatablereservations.interfaceSegregation.user;

import java.util.UUID;

public interface UserQuery {
    void fetchUser(UUID userId);
}
