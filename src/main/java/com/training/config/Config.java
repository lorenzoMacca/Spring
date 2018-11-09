package com.training.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CommandLineRunner populateDBWithStudents(){
        return args -> {

           /* noteRepository.deleteAll();
            studentRepository.deleteAll();

            EStudent s1 = new EStudent("Lorenzo Cozza", 27);
            ENote e11 = new ENote(1, s1);
            ENote e112 = new ENote(2, s1);
            studentRepository.save(s1);
            noteRepository.save(e11);
            noteRepository.save(e112);


            EStudent s2 = new EStudent("Salvatore Cozza", 18);
            ENote e12 = new ENote(2, s2);
            studentRepository.save(s2);
            noteRepository.save(e12);

            EStudent s3 = new EStudent("Andrea Tucci", 27);
            ENote e13 = new ENote(3, s3);
            studentRepository.save(s3);
            noteRepository.save(e13);

            EStudent s4 = new EStudent("Daniela Gutschmidt", 23);
            EStudent s5 = new EStudent("Francesco Ventura", 27);


            studentRepository.save(s4);
            studentRepository.save(s5);
*/
        };
    }
}
