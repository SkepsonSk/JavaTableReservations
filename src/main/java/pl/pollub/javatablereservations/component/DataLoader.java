package pl.pollub.javatablereservations.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollub.javatablereservations.Constants;
import pl.pollub.javatablereservations.entity.Status;
import pl.pollub.javatablereservations.entity.Table;
import pl.pollub.javatablereservations.repository.LogRepository;
import pl.pollub.javatablereservations.repository.RoleRepository;
import pl.pollub.javatablereservations.repository.StatusRepository;
import pl.pollub.javatablereservations.repository.TableRepository;

@Service
public class DataLoader {

    private final LogRepository logRepository;
    private final StatusRepository statusRepository;
    private final RoleRepository roleRepository;
    private final TableRepository tableRepository;

    @Autowired
    public DataLoader(
            LogRepository logRepository,
            StatusRepository statusRepository,
            RoleRepository roleRepository,
            TableRepository tableRepository
    ) {
        this.logRepository = logRepository;
        this.statusRepository = statusRepository;
        this.roleRepository = roleRepository;
        this.tableRepository = tableRepository;
    }

    public void seed() {
        DataSeeder dataSeeder = new DataSeeder();
        dataSeeder.addSeeder(new RoleSeeder(this.roleRepository));
        dataSeeder.addSeeder(new StatusSeeder(this.statusRepository, this.logRepository));

        dataSeeder.addSeeder( () -> {
            Status openStatus = this.statusRepository.findStatusByApiName(Constants.STATUS_API_NAME_TABLE_OPEN).orElseThrow();
            tableRepository.save(new Table(5, openStatus));
            tableRepository.save(new Table(8, openStatus));
            tableRepository.save(new Table(4, openStatus));
        });

        dataSeeder.seed();
    }
}
