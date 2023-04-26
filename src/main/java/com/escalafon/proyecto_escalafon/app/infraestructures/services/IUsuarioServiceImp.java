package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.infraestructures.dao.ICargoDao;
import com.escalafon.proyecto_escalafon.app.infraestructures.dao.IUsuarioDao;
import com.escalafon.proyecto_escalafon.app.models.entitys.CargoEntity;
import com.escalafon.proyecto_escalafon.app.models.entitys.UsuarioEntity;
import com.escalafon.proyecto_escalafon.app.models.resquests.UsuarioResquest;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Component("IUsuarioServiceImp")
@AllArgsConstructor
public class IUsuarioServiceImp implements IUsuarioService {


    final private IUsuarioDao usuarioDao;

    final ICargoDao cargoDao;
    public static final ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioResquest> findAll() {
        final List<UsuarioEntity> usuarioEntity = usuarioDao.findAllByEstadoIsTrue();
        return usuarioEntity.stream().map(this::convertToResquest)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UsuarioResquest save(UsuarioResquest usuarioResquest) {
        try {
            UsuarioEntity usuarioEntity = convertToEntity(usuarioResquest);
            CargoEntity cargoEntity = cargoDao.findById(usuarioEntity.getCargoEntity().getId()).orElseThrow();

            usuarioEntity.setCargoEntity(cargoEntity);
            usuarioEntity.setEstado(true);

            UsuarioEntity savedUsuario = usuarioDao.save(usuarioEntity);
            return convertToResquest(savedUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioResquest findOne(@NonNull final Integer id) {
        final UsuarioEntity usuarioEntity = getUsuarioByIdHelper(id);
        return convertToResquest(usuarioEntity);
    }


    @Transactional(readOnly = true)
    public UsuarioResquest obtnerUsuarioXcredenciales(UsuarioResquest usuarioResquest) {

        UsuarioEntity usuarioEntity = usuarioDao.findByLogin(usuarioResquest.getLogin());

        if (usuarioEntity==null) {
            return null;
        }

        String passwordHashed = usuarioEntity.getPass();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(passwordHashed, usuarioEntity.getPass())){
            return convertToResquest(usuarioEntity);
        }
        return null;
    }

    @Override
    @Transactional
    public UsuarioResquest updateUsuario(@NonNull Integer id, @NonNull UsuarioResquest usuarioResquest) {
        UsuarioEntity usuarioEntity = getUsuarioByIdHelper(id);

        if (usuarioEntity != null) {


            usuarioEntity.setNombre(usuarioResquest.getNombre());
            usuarioEntity.setApellidoPat(usuarioResquest.getApellidoPat());
            usuarioEntity.setApellidoMat(usuarioResquest.getApellidoPat());
            usuarioEntity.setFechaNaci(usuarioResquest.getFechaNaci());
            usuarioEntity.setCorreo(usuarioResquest.getCorreo());
            usuarioEntity.setLogin(usuarioResquest.getLogin());
            usuarioEntity.setPass(usuarioResquest.getPass());

            CargoEntity cargoEntity = cargoDao.findById(usuarioResquest.getCargoResquest().getId()).orElseThrow();

            usuarioEntity.setCargoEntity(cargoEntity);

            UsuarioEntity updatedUsuario = usuarioDao.save(usuarioEntity);
            return convertToResquest(updatedUsuario);
        }
        return null;

    }

    @Override
    @Transactional
    public UsuarioResquest delete(@NonNull Integer id) {
        UsuarioEntity usuarioEntity = getUsuarioByIdHelper(id);
        if (usuarioEntity != null) {
            usuarioEntity.setEstado(false);
            return convertToResquest(usuarioDao.save(usuarioEntity));
        }
        return null;
    }

    private UsuarioEntity getUsuarioByIdHelper(@NonNull Integer id) {
        return usuarioDao.findById(id)
                .orElseThrow();
    }

    public UsuarioResquest convertToResquest(UsuarioEntity usuarioEntity) {
        return mapper.map(usuarioEntity, UsuarioResquest.class);
    }

    public UsuarioEntity convertToEntity(UsuarioResquest usuarioResquest) {
        return mapper.map(usuarioResquest, UsuarioEntity.class);
    }


}
