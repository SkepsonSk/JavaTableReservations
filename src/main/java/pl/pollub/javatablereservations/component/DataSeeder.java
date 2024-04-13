package pl.pollub.javatablereservations.component;

import java.util.ArrayList;
import java.util.List;

public class DataSeeder implements Seeder {

    private final List<Seeder> seederList;

    public DataSeeder() {
        this.seederList = new ArrayList<>();
    }

    public void addSeeder(Seeder seeder) {
        this.seederList.add(seeder);
    }

    @Override
    public void seed() {
        for (Seeder seeder : seederList) {
            seeder.seed();
        }
    }

}
