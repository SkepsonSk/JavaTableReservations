package pl.pollub.javatablereservations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pollub.javatablereservations.dependencyInversion.implementationClasses.EmailNotificationService;
import pl.pollub.javatablereservations.dependencyInversion.interfaces.NotificationService;
import pl.pollub.javatablereservations.dto.NotificationDto;
import pl.pollub.javatablereservations.entity.User;
import pl.pollub.javatablereservations.notification.DatabaseNotifier;
import pl.pollub.javatablereservations.notification.DatabaseNotifierAPI;
import pl.pollub.javatablereservations.repository.NotificationRepository;

import java.util.UUID;

@RestController
@RequestMapping(value = "/")
public class NotificationController {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @PostMapping(value = "/database/notify")
    public void notifyUser(@RequestBody NotificationDto notificationDto) {
        DatabaseNotifier notifier = new DatabaseNotifier(new DatabaseNotifierAPI(notificationRepository));

        User user = new User(UUID.fromString(notificationDto.getUserId()));
        String title = notificationDto.getTitle();
        String body = notificationDto.getBody();

        notifier.doNotify(user, title, body);
    }

    @PostMapping(value = "/service/notify")
    public void notifyUserUsingService(@RequestBody NotificationDto notificationDto) {
        NotificationService notificationService = new EmailNotificationService();
        notificationService.sendNotification(notificationDto.getTitle(), notificationDto.getBody(), notificationDto.getUserId());
    }

}
