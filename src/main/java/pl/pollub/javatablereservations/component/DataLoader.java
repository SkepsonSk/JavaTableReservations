package pl.pollub.javatablereservations.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollub.javatablereservations.repository.LogRepository;
import pl.pollub.javatablereservations.repository.RoleRepository;
import pl.pollub.javatablereservations.repository.StatusRepository;

@Service
public class DataLoader {

    private final LogRepository logRepository;
    private final StatusRepository statusRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public DataLoader(
            LogRepository logRepository,
            StatusRepository statusRepository,
            RoleRepository roleRepository
    ) {
        this.logRepository = logRepository;
        this.statusRepository = statusRepository;
        this.roleRepository = roleRepository;
    }

    public void seed() {
        DataSeeder dataSeeder = new DataSeeder();
        dataSeeder.addSeeder(new RoleSeeder(this.roleRepository));
        dataSeeder.addSeeder(new StatusSeeder(this.statusRepository, this.logRepository));
        dataSeeder.seed();
    }
}
