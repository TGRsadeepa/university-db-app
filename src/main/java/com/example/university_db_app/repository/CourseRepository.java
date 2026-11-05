package com.example.university_db_app.repository;

import com.example.university_db_app.entity.Course;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByCode(String code);

    @EntityGraph(attributePaths = {"lecturer", "lecturer.department"})
    List<Course> findByCreditsGreaterThanEqual(Integer credits);

    List<Course> findByTitleContainingIgnoreCase(String text);

    List<Course> findByLecturer_Name(String lecturerName);

    @EntityGraph(attributePaths = {"lecturer", "lecturer.department"})
    List<Course> findByLecturer_Department_Name(String departmentName);

    @Override
    @EntityGraph(attributePaths = {"lecturer", "lecturer.department"})
    List<Course> findAll();
}