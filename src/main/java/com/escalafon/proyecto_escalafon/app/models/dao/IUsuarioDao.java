package com.escalafon.proyecto_escalafon.app.models.dao;

import com.escalafon.proyecto_escalafon.app.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsuarioDao extends JpaRepository<Usuario,Integer> {
    public List<Usuario> findAllByEstadoIsTrue();
}
