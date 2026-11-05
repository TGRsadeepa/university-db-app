package com.example.university_db_app.dto;

/**
 * Interface projection:
 * Spring fills these getters from the aliases in the @Query.
 */
public interface CourseEnrollmentCount {

    String getCourseCode();

    String getTitle();

    Long getStudentCount();
}
