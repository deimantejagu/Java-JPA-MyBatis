package com.example.psklab1.usecases;

import com.example.psklab1.entities.OptionalCourse;
import com.example.psklab1.entities.Student;
import com.example.psklab1.persistence.OptionalCoursesDAO;
import javax.faces.context.FacesContext;

import lombok.Getter;
import lombok.Setter;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class courseStudents {
    @Inject
    private OptionalCoursesDAO optionalCoursesDAO;

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
}
