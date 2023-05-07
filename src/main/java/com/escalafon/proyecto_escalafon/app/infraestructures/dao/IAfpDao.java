package com.escalafon.proyecto_escalafon.app.infraestructures.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalafon.proyecto_escalafon.app.models.entitys.AfpEntity;

public interface IAfpDao extends JpaRepository<AfpEntity,Integer>{
    public List<AfpEntity> findAllByEstadoIsTrue();
}
