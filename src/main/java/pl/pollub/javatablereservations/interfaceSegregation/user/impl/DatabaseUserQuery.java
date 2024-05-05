package pl.pollub.javatablereservations.interfaceSegregation.user.impl;

import pl.pollub.javatablereservations.interfaceSegregation.user.UserQuery;

import java.util.UUID;

public class DatabaseUserQuery implements UserQuery {

    @Override
    public void fetchUser(UUID userId) {
        System.out.printf("Fetching the user %s", userId.toString());
    }
}
