package pl.pollub.javatablereservations.interfaceSegregation.user;

import java.util.UUID;

//Before interface segregation
public interface UserOperations {
    void createUser(String username);
    void updateUser(UUID userId, String username);
    void deleteUser(UUID userId);
    void fetchUser(UUID userId);
}

