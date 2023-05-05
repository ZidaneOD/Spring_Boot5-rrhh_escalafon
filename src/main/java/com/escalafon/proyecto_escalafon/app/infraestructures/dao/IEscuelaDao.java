package com.escalafon.proyecto_escalafon.app.infraestructures.dao;

import com.escalafon.proyecto_escalafon.app.models.entitys.EscuelaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEscuelaDao extends JpaRepository<EscuelaEntity,Integer> {
    public List<EscuelaEntity> findAllByEstadoIsTrue();
}
