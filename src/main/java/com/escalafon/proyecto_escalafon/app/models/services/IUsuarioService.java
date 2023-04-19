package com.escalafon.proyecto_escalafon.app.models.services;

import com.escalafon.proyecto_escalafon.app.models.Res.UsuarioRes;
import com.escalafon.proyecto_escalafon.app.models.entity.Usuario;
import lombok.NonNull;

import java.util.List;
public interface IUsuarioService {
    public List<UsuarioRes> findAll();
    public UsuarioRes save(@NonNull UsuarioRes usuario);
    public UsuarioRes findOne(@NonNull Integer id);
    public UsuarioRes updateUsuario(@NonNull Integer usuarioId, @NonNull UsuarioRes usuarioRes);
    public void delete(@NonNull Integer id);

}
