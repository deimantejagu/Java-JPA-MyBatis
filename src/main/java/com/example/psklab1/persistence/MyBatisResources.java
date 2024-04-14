package com.example.psklab1.persistence;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.cdi.SessionFactoryProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.io.IOException;

// Objektas  turi būti sukurtas vienas visai aplikacijai ir išlaikomas
// per visą aplikacijos gyvavimo ciklą
@ApplicationScoped
public class MyBatisResources {

//    Sukuria SqlSessionFactory objektą, kuris bus pasiekiamas visoje aplikacijoje
    @Produces
    @ApplicationScoped
//    MyBatis komponentas, kuris yra atsakingas už sesijų su duomenų baze kūrimą
    @SessionFactoryProvider
    private SqlSessionFactory produceSqlSessionFactory() {
        try {
            return new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("MyBatisConfig.xml")
            );
        } catch (IOException e) {
            throw new RuntimeException("MyBatisResources.produceSqlSessionFactory(): ", e);
        }
    }
}