package com.escalafon.proyecto_escalafon.app.infraestructures.dao;

import com.escalafon.proyecto_escalafon.app.models.entitys.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoriaDao extends JpaRepository<CategoriaEntity,Integer> {
    public List<CategoriaEntity> findByEstadoIsTrue();
}
