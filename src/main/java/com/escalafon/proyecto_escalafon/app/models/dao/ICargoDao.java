package com.escalafon.proyecto_escalafon.app.models.dao;

import com.escalafon.proyecto_escalafon.app.models.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICargoDao extends JpaRepository<Cargo,Integer> {
    public List<Cargo> findAllByEstadoIsTrue();
}
