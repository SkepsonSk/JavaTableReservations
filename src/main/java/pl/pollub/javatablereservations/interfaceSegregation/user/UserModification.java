package pl.pollub.javatablereservations.interfaceSegregation.user;

import java.util.UUID;

public interface UserModification {
    void updateUser(UUID userId, String username);

    void deleteUser(UUID userId);
}
