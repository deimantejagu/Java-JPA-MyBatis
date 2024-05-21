package com.example.psklab1.usecases;

import com.example.psklab1.entities.StudentGroup;
import com.example.psklab1.persistence.StudentGroupsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@Model
public class StudentGroups {
    @Inject
    StudentGroupsDAO studentGroupsDAO;

    @Getter @Setter
    private StudentGroup studentGroupToCreate = new StudentGroup();

    @Getter
    private List<StudentGroup> allStudentGroups;

    @Getter @Setter
    private StudentGroup studentGroupToEdit;

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

    @Transactional
    public String updateStudentGroup(StudentGroup studentGroup, String specialty, Integer course) {
        if (studentGroup != null) {
            try {
                studentGroup.setSpecialty(specialty);
                studentGroup.setCourse(course);
                Thread.sleep(1000);
                studentGroupsDAO.update(studentGroup);
            } catch (OptimisticLockException ole) {
                return "index?faces-redirect=true&error=optimistic-lock-exception";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "index?faces-redirect=true";
        }
        return null;
    }
}
