package pl.piasta.acmanagement.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("pl.piasta.acmanagement")
@EntityScan("pl.piasta.acmanagement")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
