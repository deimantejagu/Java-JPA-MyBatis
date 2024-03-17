package com.example.psklab1.usecases;

import com.example.psklab1.entities.Student;
import com.example.psklab1.entities.StudentGroup;
import com.example.psklab1.persistence.StudentsDAO;
import com.example.psklab1.persistence.StudentGroupsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class StudentsForGroup implements Serializable {
    @Inject
    private StudentGroupsDAO studentGroupsDAO;

    @Inject
    private StudentsDAO studentsDAO;

    @Getter @Setter
    private StudentGroup studentGroup;

    @Getter @Setter
    private Student studentToCreate = new Student();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long studentGroupId = Long.parseLong(requestParameters.get("studentGroupId"));
        this.studentGroup = studentGroupsDAO.findOne(studentGroupId);
    }

    @Transactional
    public void createStudent() {
        studentToCreate.setStudentGroup(this.studentGroup);
        studentsDAO.persist(studentToCreate);
    }
}
