package com.escalafon.proyecto_escalafon.app.infraestructures.dao;

import com.escalafon.proyecto_escalafon.app.models.entitys.DedicacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDedicacionDao extends JpaRepository<DedicacionEntity,Integer> {
    public List<DedicacionEntity>findAllByEstadoIsTrue();
}
