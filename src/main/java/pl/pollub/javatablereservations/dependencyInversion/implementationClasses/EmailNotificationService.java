package pl.pollub.javatablereservations.dependencyInversion.implementationClasses;

import pl.pollub.javatablereservations.dependencyInversion.abstractClasses.BaseNotificationService;

public class EmailNotificationService extends BaseNotificationService {
    @Override
    public void sendNotification(String title, String body, String userId) {
        System.out.printf("Sent via email (title: %s; body: %s) to the user: %s", title, body, userId);
    }
}