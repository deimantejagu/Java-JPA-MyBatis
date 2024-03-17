package com.example.psklab1.usecases;

import com.example.psklab1.entities.StudentGroup;
import com.example.psklab1.persistence.StudentGroupDAO;
import lombok.Getter;
import lombok.Setter;
import javax.transaction.Transactional;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class StudentGroups {
    @Inject
    StudentGroupDAO studentGroupDAO;

    @Getter @Setter
    private StudentGroup studentGroupToCreate = new StudentGroup();

    @Getter
    private List<StudentGroup> allStudentGroups;

    @PostConstruct
    public void init() {
        loadAllGroups();
    }

    @Transactional
    public void createStudentGroup() {
        this.studentGroupDAO.persist(studentGroupToCreate);
    }

    private void loadAllGroups() {
        this.allStudentGroups = studentGroupDAO.loadAll();
    }
}
