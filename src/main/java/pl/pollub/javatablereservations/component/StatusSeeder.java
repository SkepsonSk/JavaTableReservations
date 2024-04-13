package pl.pollub.javatablereservations.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.pollub.javatablereservations.entity.Status;
import pl.pollub.javatablereservations.logger.DatabaseLogger;
import pl.pollub.javatablereservations.repository.LogRepository;
import pl.pollub.javatablereservations.repository.StatusRepository;

public class StatusSeeder implements Seeder {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatusSeeder.class);

    private final Logger databaseLogger;
    private final StatusRepository statusRepository;

    public StatusSeeder(StatusRepository statusRepository, LogRepository logRepository) {
        this.databaseLogger = new DatabaseLogger(LOGGER, logRepository);
        this.statusRepository = statusRepository;
    }

    @Override
    public void seed() {
        if (this.statusRepository.findAll().isEmpty()) {
            databaseLogger.info("Creating STATUS records...");

            this.statusRepository.save(new Status("TABLE_OPEN", "stolik czynny"));
            this.statusRepository.save(new Status("TABLE_CLOSED", "stolik zamknięty"));
            this.statusRepository.save(new Status("RES_NEW", "Nowa"));
            this.statusRepository.save(new Status("RES_ACC", "Zaakceptowana"));
            this.statusRepository.save(new Status("RES_CAN", "Anulowana"));
            this.statusRepository.save(new Status("RES_END", "Zakończona"));
            this.statusRepository.save(new Status("USER_ACTIVE", "Aktywny"));
            this.statusRepository.save(new Status("USER_BLOCKED", "Zablokowany"));

            databaseLogger.info("STATUS records created.");
        }
        else {
            databaseLogger.info("Skipping STATUS records creation");
        }
    }
}
