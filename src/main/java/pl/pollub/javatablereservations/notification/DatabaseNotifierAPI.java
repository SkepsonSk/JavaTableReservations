package pl.pollub.javatablereservations.notification;

import pl.pollub.javatablereservations.entity.Notification;
import pl.pollub.javatablereservations.entity.User;
import pl.pollub.javatablereservations.repository.NotificationRepository;

public class DatabaseNotifierAPI implements NotifierAPI {

    private final NotificationRepository notificationRepository;

    public DatabaseNotifierAPI(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void doNotify(User user, String title, String body) {
        this.notificationRepository.save(new Notification(title, body, user));
    }

}
