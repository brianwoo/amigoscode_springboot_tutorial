package com.example.demo.enrolled;

import com.example.demo.course.Course;
import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrolledService {

    private final EnrolledRepository enrolledRepository;

    @Autowired
    public EnrolledService(EnrolledRepository enrolledRepository) {
        this.enrolledRepository = enrolledRepository;
    }

    public List<Student> getEnrolledStudentsByCourse(Long courseId) {
        Course course = new Course(courseId);
        return this.enrolledRepository.findEnrolledStudentsByCourse(course).orElse(List.of());
    }

    public List<Enrolled> getEnrolled() {
        return this.enrolledRepository.findAll();
    }

    public void enrollCourse(Enrolled enrolled) {
        enrolled.setDateEnrolled(LocalDate.now());
        this.enrolledRepository.save(enrolled);
    }
}
