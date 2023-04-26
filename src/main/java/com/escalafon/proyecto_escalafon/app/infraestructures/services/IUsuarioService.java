package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.models.resquests.UsuarioResquest;
import lombok.NonNull;

import java.util.List;

public interface IUsuarioService {
    public List<UsuarioResquest> findAll();

    public UsuarioResquest save(@NonNull UsuarioResquest usuarioResquest);

    public UsuarioResquest findOne(@NonNull Integer id);

    public UsuarioResquest updateUsuario(@NonNull Integer id, @NonNull UsuarioResquest usuarioResquest);

    public UsuarioResquest delete(@NonNull Integer id);

}
