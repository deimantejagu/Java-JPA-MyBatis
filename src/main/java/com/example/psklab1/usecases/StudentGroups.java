package com.example.psklab1.usecases;

import com.example.psklab1.entities.StudentGroup;
import com.example.psklab1.persistence.StudentGroupsDAO;
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
    StudentGroupsDAO studentGroupsDAO;

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
        this.studentGroupsDAO.persist(studentGroupToCreate);
    }

    private void loadAllGroups() {
        this.allStudentGroups = studentGroupsDAO.loadAll();
    }

    @Transactional
    public void deleteGroup(Long groupId) {
        StudentGroup group = studentGroupsDAO.findOne(groupId);
        if(group != null){
            studentGroupsDAO.delete(group);
            loadAllGroups();
        }
    }
}
