package com.escalafon.proyecto_escalafon.app.infraestructures.dao;

import com.escalafon.proyecto_escalafon.app.models.entitys.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsuarioDao extends JpaRepository<UsuarioEntity,Integer> {
    public List<UsuarioEntity> findAllByEstadoIsTrue();
    public UsuarioEntity findByLogin(String login);
}
