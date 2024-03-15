package com.example.psklab1.usecases;

import com.example.psklab1.persistence.GrupeDAO;
import com.example.psklab1.entities.Grupe;
import lombok.Getter;
import lombok.Setter;
import org.mybatis.cdi.Transactional;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class Grupes {
    @Inject GrupeDAO grupeDAO;

    @Getter @Setter
    private Grupe grupeToCreate = new Grupe();

    @Getter
    private List<Grupe> allGrupes;

    @PostConstruct
    public void init() {
        loadAllGrupes();
    }

    @Transactional
    public void createGrupe() {
        this.grupeDAO.createGrupe(grupeToCreate);
    }

    private void loadAllGrupes() {
        this.allGrupes = grupeDAO.loadGrupes();
    }
}
