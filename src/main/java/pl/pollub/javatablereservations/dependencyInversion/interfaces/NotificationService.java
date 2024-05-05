package pl.pollub.javatablereservations.dependencyInversion.interfaces;

public interface NotificationService {
    void sendNotification(String title, String body, String userId);
}
