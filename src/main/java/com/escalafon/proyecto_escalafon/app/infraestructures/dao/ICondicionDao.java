package com.escalafon.proyecto_escalafon.app.infraestructures.dao;

import com.escalafon.proyecto_escalafon.app.models.entitys.CondicionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICondicionDao extends JpaRepository<CondicionEntity,Integer> {
    public List<CondicionEntity> findAllByEstadoIsTrue();
}
