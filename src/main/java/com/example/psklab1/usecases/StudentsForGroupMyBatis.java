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
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Model
public class StudentsForGroupMyBatis {
    @Inject
    private StudentMapper studentMapper;

    @Inject
    private StudentGroupMapper studentGroupMapper;

    @Getter @Setter
    private StudentGroup studentGroup;

    @Getter @Setter
    private Student studentToCreate = new Student();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long studentGroupId = Long.parseLong(requestParameters.get("studentGroupId"));
        this.studentGroup = studentGroupMapper.selectByPrimaryKey(studentGroupId);
    }

    public List<Student> getStudentsForGroup(Long studentGroupId) {
        return studentMapper.selectByStudentGroupId(studentGroupId);
    }

    @Transactional
    public String createStudent() {
        studentToCreate.setStudentgroupId(studentGroup.getId());
        studentMapper.insert(studentToCreate);
        return "myBatis/students.xhtml?faces-redirect=true";
    }
}
