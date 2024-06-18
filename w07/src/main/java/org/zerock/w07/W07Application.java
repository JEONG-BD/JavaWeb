package org.zerock.w07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class W07Application {

    public static void main(String[] args) {
        SpringApplication.run(W07Application.class, args);
    }

}
