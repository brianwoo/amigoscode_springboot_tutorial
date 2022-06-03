package com.example.demo.enrolled;

import com.example.demo.course.Course;
import com.example.demo.student.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "enrolled_courses")
public class Enrolled {

    @Id
    @SequenceGenerator(
            name = "enrolled_sequence",
            sequenceName = "enrolled_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "enrolled_sequence"
    )
    private Long id;

    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(name = "course_id")
    @JsonProperty("course_id")
    private Course course;

    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name="student_id")
    @JsonProperty("student_id")
    private Student student;

    private LocalDate dateEnrolled;

    public Enrolled() {
    }

    public Enrolled(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(LocalDate dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

    @Override
    public String toString() {
        return "Enrolled{" +
                "id=" + id +
                ", course=" + course +
                ", student=" + student +
                ", dateEnrolled=" + dateEnrolled +
                '}';
    }
}
