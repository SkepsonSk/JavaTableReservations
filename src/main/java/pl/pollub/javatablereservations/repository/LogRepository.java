package pl.pollub.javatablereservations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub.javatablereservations.entity.Log;

import java.util.UUID;

public interface LogRepository extends JpaRepository<Log, UUID> {
}
