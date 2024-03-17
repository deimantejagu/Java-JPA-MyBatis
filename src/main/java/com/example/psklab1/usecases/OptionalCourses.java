package com.example.psklab1.usecases;

import com.example.psklab1.entities.OptionalCourse;
import com.example.psklab1.entities.Student;
import com.example.psklab1.persistence.OptionalCoursesDAO;
import com.example.psklab1.persistence.StudentsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

@Model
public class OptionalCourses {
    @Inject
    private OptionalCoursesDAO optionalCoursesDAO;

    @Inject
    private StudentsDAO studentsDAO;

    @Getter @Setter
    private Student student;

    @Getter @Setter
    private OptionalCourse optionalCourseToCreate = new OptionalCourse();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long studentId = Long.parseLong(requestParameters.get("studentId"));
        this.student = studentsDAO.findOne(studentId);
    }

    @Transactional
    public String createOptionalCourse() {
        Optional<OptionalCourse> existingCourse = optionalCoursesDAO.findByName(optionalCourseToCreate.getName());

        if (existingCourse.isPresent()) {
            student.getOptionalCourses().add(existingCourse.get());
        } else {
            optionalCoursesDAO.persist(optionalCourseToCreate);
            student.getOptionalCourses().add(optionalCourseToCreate);
        }

        studentsDAO.update(student);

        return "success";
    }
}
