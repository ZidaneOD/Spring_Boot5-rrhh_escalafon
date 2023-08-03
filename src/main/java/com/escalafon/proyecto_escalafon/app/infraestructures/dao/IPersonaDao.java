package com.escalafon.proyecto_escalafon.app.infraestructures.dao;

import com.escalafon.proyecto_escalafon.app.models.entitys.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPersonaDao extends JpaRepository<PersonaEntity,Integer> {
    public List<PersonaEntity>findAllByEstadoIsTrue();
}
