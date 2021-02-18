package com.raims.springdemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.OCTOBER;
import static java.time.Month.SEPTEMBER;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student raimundo = new Student(
                    "Raimundo",
                    "raimundo@gmail.com",
                    LocalDate.of(1982, OCTOBER, 19));

            Student azevedo = new Student(
                    "Azevedo",
                    "azevedo@gmail.com",
                    LocalDate.of(1981, SEPTEMBER, 3));

            studentRepository.saveAll(
                    List.of(raimundo, azevedo)
            );
        };
    }
}
