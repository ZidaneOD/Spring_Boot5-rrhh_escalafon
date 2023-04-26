package com.escalafon.proyecto_escalafon.app.infraestructures.dao;

import com.escalafon.proyecto_escalafon.app.models.entitys.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICargoDao extends JpaRepository<CargoEntity,Integer> {

    public List<CargoEntity> findAllByEstadoIsTrue();
}
