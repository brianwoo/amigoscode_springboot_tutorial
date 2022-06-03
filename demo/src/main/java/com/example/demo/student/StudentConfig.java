package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student brian = new Student(
                    "Brian",
                    "brian.woo@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student elon = new Student(
                    "Elon",
                    "elon@musk.com",
                    LocalDate.of(1971, Month.JUNE,28 )
            );

            repository.saveAll(List.of(brian, elon));
        };
    }
}
