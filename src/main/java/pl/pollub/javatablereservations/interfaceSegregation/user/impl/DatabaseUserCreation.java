package pl.pollub.javatablereservations.interfaceSegregation.user.impl;

import pl.pollub.javatablereservations.interfaceSegregation.user.UserCreation;

public class DatabaseUserCreation implements UserCreation {

    @Override
    public void createUser(String username) {
        System.out.printf("Creating user with %s username", username);
    }
}
