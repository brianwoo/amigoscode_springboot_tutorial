package com.example.demo.enrolled;

import com.example.demo.course.Course;
import com.example.demo.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrolledRepository extends JpaRepository<Enrolled, Long> {

    @Query("SELECT e.student FROM Enrolled e WHERE e.course = ?1")
    Optional<List<Student>> findEnrolledStudentsByCourse(Course course);}
