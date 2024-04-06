package com.example.psklab1.usecases;

import com.example.psklab1.entities.OptionalCourse;
import com.example.psklab1.entities.Student;
import com.example.psklab1.persistence.OptionalCoursesDAO;
import javax.faces.context.FacesContext;

import com.example.psklab1.persistence.StudentsDAO;
import lombok.Getter;
import lombok.Setter;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class CourseStudents {
    @Inject
    private OptionalCoursesDAO optionalCoursesDAO;

    @Inject
    private StudentsDAO studentsDAO;

    @Getter @Setter
    private OptionalCourse course;

    @Getter @Setter
    private List<Student> students;

    @Getter @Setter
    private Long selectedCourseId;

    @PostConstruct
    public void init() {
        selectedCourseId = getCourseIdFromRequest();
        course = optionalCoursesDAO.findOne(selectedCourseId);
        students = course.getStudents();
    }

    private Long getCourseIdFromRequest() {
        String courseId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("optionalCourseId");
        return Long.valueOf(courseId);
    }

    @Transactional
    public void removeStudentFromCourse(Long studentId) {
        Student student = studentsDAO.findOne(studentId);
        if (student != null) {
            course.getStudents().remove(student);
            student.getOptionalCourses().remove(course);
            studentsDAO.removeStudentFromCourse(student);
        }
    }
}
