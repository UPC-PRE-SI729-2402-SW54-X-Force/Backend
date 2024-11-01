package xforce.drivenowbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DrivenowBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrivenowBackendApplication.class, args);
    }

}
