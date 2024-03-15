package com.example.psklab1.mybatis.dao;

import com.example.psklab1.mybatis.model.Grupe;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface GrupeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.GRUPE
     *
     * @mbg.generated Fri Mar 15 17:50:13 EET 2024
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.GRUPE
     *
     * @mbg.generated Fri Mar 15 17:50:13 EET 2024
     */
    int insert(Grupe record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.GRUPE
     *
     * @mbg.generated Fri Mar 15 17:50:13 EET 2024
     */
    Grupe selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.GRUPE
     *
     * @mbg.generated Fri Mar 15 17:50:13 EET 2024
     */
    List<Grupe> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.GRUPE
     *
     * @mbg.generated Fri Mar 15 17:50:13 EET 2024
     */
    int updateByPrimaryKey(Grupe record);
}