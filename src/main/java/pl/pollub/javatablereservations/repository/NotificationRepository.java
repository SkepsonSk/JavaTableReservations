package pl.pollub.javatablereservations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub.javatablereservations.entity.Notification;

import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {
}
