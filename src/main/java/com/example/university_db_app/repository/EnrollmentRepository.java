package com.example.university_db_app.repository;

import com.example.university_db_app.dto.CourseEnrollmentCount;
import com.example.university_db_app.entity.Enrollment;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    @EntityGraph(attributePaths = {"student", "course"})
    List<Enrollment> findByStudent_StudentCode(String studentCode);

    @EntityGraph(attributePaths = "student")
    List<Enrollment> findByCourse_Code(String courseCode);

    @EntityGraph(attributePaths = {"student", "course"})
    List<Enrollment> findByGrade(String grade);

    @EntityGraph(attributePaths = "student")
    List<Enrollment> findByStudent_StudentCodeAndGrade(
            String studentCode, String grade);

    long countByCourse_Code(String courseCode);

    @Query("SELECT c.code AS courseCode, c.title AS title, COUNT(e) AS studentCount " +
           "FROM Enrollment e JOIN e.course c " +
           "GROUP BY c.code, c.title " +
           "ORDER BY COUNT(e) DESC, c.code")
    List<CourseEnrollmentCount> countStudentsPerCourse();
}