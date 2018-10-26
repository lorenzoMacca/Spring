package com.springboot.beispiele.springbootBeispiele.config;

import com.springboot.beispiele.springbootBeispiele.entities.EStudent;
import com.springboot.beispiele.springbootBeispiele.repo.IRStudent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CommandLineRunner populateDBWithStudents(IRStudent repository ){
        return args -> {
            repository.save(new EStudent("Lorenzo Cozza"));
            repository.save(new EStudent("Salvatore Cozza"));
            repository.save(new EStudent("Andrea Tucci"));
            repository.save(new EStudent("Daniela Gutschmidt"));
            repository.save(new EStudent("Francesco Ventura"));

        };
    }
}
