package pl.pollub.javatablereservations.wrongClass;

import java.util.*;

public class UserManager {

    private final List<UserDetails> users = new ArrayList<>();

    public void addUser(String username) {
        UserDetails details = new UserDetails(username);
        if (!this.userExists(username)) {
            users.add(details);
        } else {
            System.out.println("User already exists");
        }
    }

    public void removeUser(String username) {
        if (this.userExists(username)) {
            this.users.removeIf( user -> user.getEmail().equals(username) );
        } else {
            System.out.println("User does not exist");
        }
    }

    public boolean userExists(String username) {
        return this.users.stream().anyMatch( user -> user.getEmail().equals(username) );
    }

    public void printUsers() {
        for (UserDetails user : this.users) {
            System.out.println("User: " + user.getEmail());
        }
    }

    public void printUserDetails(String username) {
        if (this.userExists(username)) {
            UserDetails userDetails = this.users.stream().filter(  user -> user.getEmail().equals(username) ).findFirst().orElseThrow();
            System.out.println("User details:\nEmail: " + userDetails.getEmail() + "\nAddress: " + userDetails.getAddress() + "\nPhone: " + userDetails.getPhone());
        } else {
            System.out.println("User does not exist");
        }
    }

    public void updateUserDetails(UserDetails userDetails) {
        if (this.userExists(userDetails.getEmail())) {

            UserDetails details = this.users.stream().filter(  user -> user.getEmail().equals(userDetails.getEmail()) ).findFirst().orElseThrow();
            details.setEmail(userDetails.getEmail());
            details.setAddress(userDetails.getAddress());
            details.setPhone(userDetails.getPhone());

            System.out.println("User details for have been updated.");
        } else {
            System.out.println("User does not exist");
        }
    }
}

