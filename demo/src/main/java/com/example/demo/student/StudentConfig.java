package com.example.demo.student;

import com.example.demo.course.Course;
import com.example.demo.course.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(CourseRepository courseRepository, StudentRepository studentRepository) {
        return args -> {
            Course science101 = new Course(
                    "sci101-01",
                    LocalDateTime.of(2022, 01,3,14, 30),
                    LocalDateTime.of(2022, 06,3,15, 30)
            );
            Course courseAdded = courseRepository.save(science101);

            System.out.println("course added: " + courseAdded);

            Student brian = new Student(
                    "Brian",
                    "brian.woo@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );
//            brian.setCourse(courseAdded);

            Student elon = new Student(
                    "Elon",
                    "elon@musk.com",
                    LocalDate.of(1971, Month.JUNE,28 )
            );

            studentRepository.saveAll(List.of(brian, elon));
        };
    }
}
