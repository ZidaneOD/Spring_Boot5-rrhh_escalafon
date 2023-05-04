package com.escalafon.proyecto_escalafon.app.infraestructures.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalafon.proyecto_escalafon.app.models.entitys.EstadoCivilEntity;

public interface IEstadoCivilDao extends JpaRepository<EstadoCivilEntity,Integer> {
    public List<EstadoCivilEntity> findAllByEstadoIsTrue();
}

