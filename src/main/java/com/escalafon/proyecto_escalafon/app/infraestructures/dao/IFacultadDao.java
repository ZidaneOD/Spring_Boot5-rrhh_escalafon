package com.escalafon.proyecto_escalafon.app.infraestructures.dao;

import com.escalafon.proyecto_escalafon.app.models.entitys.FacultadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFacultadDao extends JpaRepository<FacultadEntity,Integer> {
    public List<FacultadEntity> findAllByEstadoIsTrue();
}
