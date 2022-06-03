package com.example.demo.enrolled;

import com.example.demo.student.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/enrolled")
public class EnrolledController {

    private EnrolledService enrolledService;

    public EnrolledController(EnrolledService enrolledService) {
        this.enrolledService = enrolledService;
    }

    @GetMapping
    public List<Enrolled> getEnrolled() {
        return enrolledService.getEnrolled();
    }

    @PostMapping
    public void enrollCourse(@RequestBody Enrolled enrolled) {
        enrolledService.enrollCourse(enrolled);
    }

    @GetMapping(path = "{courseId}")
    public List<Student> getEnrolledStudentsByCourse(@PathVariable Long courseId) {
        return enrolledService.getEnrolledStudentsByCourse(courseId);
    }
}
