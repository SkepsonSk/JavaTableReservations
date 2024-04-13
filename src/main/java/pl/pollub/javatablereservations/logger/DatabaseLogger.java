package pl.pollub.javatablereservations.logger;

import org.slf4j.Logger;
import pl.pollub.javatablereservations.entity.Log;
import pl.pollub.javatablereservations.repository.LogRepository;

public class DatabaseLogger extends LoggerDecorator {

    private final LogRepository logRepository;

    public DatabaseLogger(Logger loggerBase, LogRepository logRepository) {
        super(loggerBase);
        this.logRepository = logRepository;
    }

    @Override
    public void info(String s) {
        super.info(s);
        this.logRepository.save(new Log(s));
    }
}
