package com.escalafon.proyecto_escalafon.app.infraestructures.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.escalafon.proyecto_escalafon.app.models.entitys.RegimenPensionEntity;

public interface IRegimenPensionDao extends  JpaRepository<RegimenPensionEntity,Integer> {
    public List<RegimenPensionEntity> findAllByEstadoIsTrue();
}
