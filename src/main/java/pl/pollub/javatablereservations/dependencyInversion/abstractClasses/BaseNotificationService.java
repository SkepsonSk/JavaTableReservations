package pl.pollub.javatablereservations.dependencyInversion.abstractClasses;
import pl.pollub.javatablereservations.dependencyInversion.interfaces.NotificationService;

public abstract class BaseNotificationService implements NotificationService {
    public abstract void sendNotification(String title, String body, String userId);

}
