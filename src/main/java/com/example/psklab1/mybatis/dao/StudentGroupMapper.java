package com.example.psklab1.mybatis.dao;

import com.example.psklab1.mybatis.model.StudentGroup;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface StudentGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENTGROUP
     *
     * @mbg.generated Mon Mar 18 16:46:19 EET 2024
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENTGROUP
     *
     * @mbg.generated Mon Mar 18 16:46:19 EET 2024
     */
    int insert(StudentGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENTGROUP
     *
     * @mbg.generated Mon Mar 18 16:46:19 EET 2024
     */
    StudentGroup selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENTGROUP
     *
     * @mbg.generated Mon Mar 18 16:46:19 EET 2024
     */
    List<StudentGroup> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENTGROUP
     *
     * @mbg.generated Mon Mar 18 16:46:19 EET 2024
     */
    int updateByPrimaryKey(StudentGroup record);
}