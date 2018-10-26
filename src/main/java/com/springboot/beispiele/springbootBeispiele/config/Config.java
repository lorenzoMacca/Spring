package com.springboot.beispiele.springbootBeispiele.config;

import com.springboot.beispiele.springbootBeispiele.entities.ENote;
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

            //noteRepository.deleteAll();
            //studentRepository.deleteAll();

            EStudent s1 = new EStudent("Lorenzo Cozza");
            ENote e11 = new ENote(1, s1);

            studentRepository.save(s1);
            noteRepository.save(e11);

            EStudent s2 = new EStudent("Salvatore Cozza");
            ENote e12 = new ENote(2, s2);
            studentRepository.save(s2);
            noteRepository.save(e12);

            EStudent s3 = new EStudent("Andrea Tucci");
            ENote e13 = new ENote(3, s3);
            studentRepository.save(s3);
            noteRepository.save(e13);

            EStudent s4 = new EStudent("Daniela Gutschmidt");
            EStudent s5 = new EStudent("Francesco Ventura");




            studentRepository.save(s4);
            studentRepository.save(s5);

        };
    }
}
