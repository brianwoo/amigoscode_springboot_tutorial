package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// @Component or @Service makes StudentService a Spring Bean
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
        if (studentRepository.findStudentByEmail(student.getEmail()).isPresent()) {
            throw new IllegalStateException("Email Taken!");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> {
            throw new IllegalStateException("Cannot find student ID " + studentId);
        });

        if (name != null && !student.getName().equals(name)) {
            student.setName(name);
        }

        if (email != null && !student.getEmail().equals(email)) {
            student.setEmail(email);
        }

        // Don't need to save because we are using a managed transaction (@Transactional)
        // studentRepository.saveAndFlush(student);
    }
}
