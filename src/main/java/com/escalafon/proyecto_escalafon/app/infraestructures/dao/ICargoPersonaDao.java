package com.escalafon.proyecto_escalafon.app.infraestructures.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.escalafon.proyecto_escalafon.app.models.entitys.CargoPersonaEntity;

public interface ICargoPersonaDao extends JpaRepository<CargoPersonaEntity,Integer> {
    public List<CargoPersonaEntity> findAllByEstadoIsTrue();
}
