package br.edu.utfpr.troubleshootingstandards.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonDTO implements Serializable {

    private Long id;
    private ClassCourseDTO classCourse;
    private Set<String> type;
    private AttendanceStudentDTO attendanceStudent;
    private String content;
    private int numberClasses;
    private LocalDate date;

}