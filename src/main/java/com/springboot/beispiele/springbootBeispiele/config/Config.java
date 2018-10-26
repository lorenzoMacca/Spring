package com.springboot.beispiele.springbootBeispiele.config;

import com.springboot.beispiele.springbootBeispiele.entities.EStudent;
import com.springboot.beispiele.springbootBeispiele.repo.IRNote;
import com.springboot.beispiele.springbootBeispiele.repo.IRStudent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CommandLineRunner populateDBWithStudents(IRStudent studentRepository, IRNote noteRepository){
        return args -> {

            studentRepository.deleteAll();

            EStudent s1 = new EStudent("Lorenzo Cozza");
            EStudent s2 = new EStudent("Salvatore Cozza");
            EStudent s3 = new EStudent("Andrea Tucci");
            EStudent s4 = new EStudent("Daniela Gutschmidt");
            EStudent s5 = new EStudent("Francesco Ventura");

            studentRepository.save(s1);
            studentRepository.save(s2);
            studentRepository.save(s3);
            studentRepository.save(s4);
            studentRepository.save(s5);

        };
    }
}
