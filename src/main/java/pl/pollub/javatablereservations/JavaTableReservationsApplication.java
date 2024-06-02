package pl.pollub.javatablereservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class JavaTableReservationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaTableReservationsApplication.class, args);
    }

}
