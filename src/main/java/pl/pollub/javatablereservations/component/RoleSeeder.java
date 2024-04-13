package pl.pollub.javatablereservations.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.pollub.javatablereservations.entity.Role;
import pl.pollub.javatablereservations.repository.RoleRepository;

public class RoleSeeder implements Seeder {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleSeeder.class);


    private final RoleRepository roleRepository;

    public RoleSeeder(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void seed() {
        if (this.roleRepository.findAll().isEmpty()) {
            LOGGER.info("Creating ROLE records...");

            this.roleRepository.save(new Role("Admin"));
            this.roleRepository.save(new Role("Manager"));
            this.roleRepository.save(new Role("Employee"));

            LOGGER.info("ROLE records created.");
        }
        else {
            LOGGER.info("Skipping ROLE records creation");
        }
    }
}
