package com.example.psklab1.usecases;

import com.example.psklab1.mybatis.dao.StudentGroupMapper;
import com.example.psklab1.mybatis.dao.StudentMapper;
import com.example.psklab1.mybatis.model.Student;
import com.example.psklab1.mybatis.model.StudentGroup;
import lombok.Getter;
import lombok.Setter;
import org.mybatis.cdi.Transactional;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class StudentGroupsMyBatis {
    @Inject
    private StudentGroupMapper studentGroupMapper;

    @Inject
    private StudentMapper studentMapper;

    @Getter
    private List<StudentGroup> allStudentGroups;

    @Getter @Setter
    private StudentGroup studentGroupToCreate = new StudentGroup();

    @PostConstruct
    public void init() {
        this.loadAllStudentGroups();
    }

    private void loadAllStudentGroups() {
        this.allStudentGroups = studentGroupMapper.selectAll();
    }

    @Transactional
    public String createStudentGroup(){
        studentGroupMapper.insert(studentGroupToCreate);
        return "/myBatis/studentGroups?faces-redirect=true";
    }

    @Transactional
    public String deleteStudentGroup(Long id) {
        List<Student> students = studentMapper.selectByStudentGroupId(id);

        for (Student student : students) {
            studentMapper.deleteByPrimaryKey(student.getId());
        }

        studentGroupMapper.deleteByPrimaryKey(id);
        return "/myBatis/studentGroups.xhtml?faces-redirect=true";
    }
}
