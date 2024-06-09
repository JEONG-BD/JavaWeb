package org.zerock.w06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class W06Application {

    public static void main(String[] args) {
        SpringApplication.run(W06Application.class, args);
    }

}
