package com.escalafon.proyecto_escalafon.app.models.services;

import com.escalafon.proyecto_escalafon.app.models.Res.UsuarioRes;
import com.escalafon.proyecto_escalafon.app.models.dao.IUsuarioDao;
import com.escalafon.proyecto_escalafon.app.models.entity.Usuario;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Component("IUsuarioServiceImp")
public class IUsuarioServiceImp implements IUsuarioService {

    @Autowired
    private IUsuarioDao usuarioDao;
    public static final ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioRes> findAll() {
        final List<Usuario> usuarios = usuarioDao.findAllByEstadoIsTrue();
        return usuarios.stream().map(this::convertToRest)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UsuarioRes save(UsuarioRes usuarioRes) {

        try {
            Usuario usuarioEntity = convertToEntity(usuarioRes);
            Usuario savedDoctor = usuarioDao.save(usuarioEntity);
            return convertToRest(savedDoctor);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioRes findOne(@NonNull final Integer id) {
        final Usuario usuario = getUsuarioByIdHelper(id);
        return convertToRest(usuario);
    }

    @Override
    @Transactional
    public UsuarioRes updateUsuario(@NonNull Integer usuarioId, @NonNull UsuarioRes usuarioRes) {
        getUsuarioByIdHelper(usuarioId);
        Usuario usuarioEntity = convertToEntity(usuarioRes);
        usuarioEntity.setIdUsuario(usuarioId);
        Usuario updatedDoctor = usuarioDao.save(usuarioEntity);
        return convertToRest(updatedDoctor);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        usuarioDao.deleteById(id);
    }

    private Usuario getUsuarioByIdHelper(@NonNull Integer Id) {
        return usuarioDao.findById(Id)
                .orElseThrow();
    }

    public UsuarioRes convertToRest(Usuario usuario) {
        return mapper.map(usuario, UsuarioRes.class);
    }

    public Usuario convertToEntity(UsuarioRes doctorRest) {
        return mapper.map(doctorRest, Usuario.class);
    }
}
