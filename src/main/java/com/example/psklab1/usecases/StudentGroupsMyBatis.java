package com.example.psklab1.usecases;

import com.example.psklab1.mybatis.dao.StudentgroupMapper;
import com.example.psklab1.mybatis.model.Studentgroup;
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
    private StudentgroupMapper studentGroupMapper;

    @Getter
    private List<Studentgroup> allStudentGroups;

    @Getter @Setter
    private Studentgroup studentGroupToCreate = new Studentgroup();

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
        return "/mybatis/studentGroups?faces-redirect=true";
    }
}
