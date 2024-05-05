package pl.pollub.javatablereservations.interfaceSegregation.user.impl;

import pl.pollub.javatablereservations.interfaceSegregation.user.UserModification;

import java.util.UUID;

public class DatabaseUserModification implements UserModification {

    @Override
    public void updateUser(UUID userId, String username) {
        System.out.printf("Updating the user %s with the username %s", userId.toString(), username);
    }

    @Override
    public void deleteUser(UUID userId) {
        System.out.printf("Deleting the user %s", userId.toString());
    }
}
