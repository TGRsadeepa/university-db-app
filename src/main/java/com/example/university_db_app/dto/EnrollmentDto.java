package com.example.university_db_app.dto;
import com.example.university_db_app.entity.Enrollment;

public record EnrollmentDto(
        String studentCode,
        String studentName,
        String courseCode,
        String courseTitle,
        String grade
) {

    public static EnrollmentDto from(Enrollment e) {
        return new EnrollmentDto(
                e.getStudent().getStudentCode(),
                e.getStudent().getFullName(),
                e.getCourse().getCode(),
                e.getCourse().getTitle(),
                e.getGrade()
        );
    }
}
