package org.ezcab.ezcabauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EzCabAuthServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(EzCabAuthServiceApplication.class, args);

    }

}
