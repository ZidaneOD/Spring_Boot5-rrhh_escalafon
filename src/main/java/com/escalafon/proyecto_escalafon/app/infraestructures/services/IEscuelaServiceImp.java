package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.infraestructures.dao.IEscuelaDao;
import com.escalafon.proyecto_escalafon.app.infraestructures.dao.IFacultadDao;
import com.escalafon.proyecto_escalafon.app.models.entitys.EscuelaEntity;
import com.escalafon.proyecto_escalafon.app.models.entitys.FacultadEntity;
import com.escalafon.proyecto_escalafon.app.models.resquests.EscuelaResquest;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Component("IEscuelaServiceImp")
@AllArgsConstructor
public class IEscuelaServiceImp implements IEscuelaService {
    private final IEscuelaDao escuelaDao;
    private final IFacultadDao facultadDao;
    public static final ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public List<EscuelaResquest> findAll() {
        final List<EscuelaEntity> escuelaEntity = escuelaDao.findAllByEstadoIsTrue();
        return escuelaEntity.stream().map(this::convertToResquest).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EscuelaResquest save(@NonNull EscuelaResquest escuela) {
        try {
            EscuelaEntity escuelaEntity = convertToEntity(escuela);
            FacultadEntity facultadEntity=facultadDao.findById(escuela.getIdEscuela()).orElseThrow();
            escuelaEntity.setEstado(true);
            escuelaEntity.setFacultad(facultadEntity);
            EscuelaEntity savedEscuela = escuelaDao.save(escuelaEntity);
            return convertToResquest(savedEscuela);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public EscuelaResquest findOne(@NonNull Integer id) {
        final EscuelaEntity escuelaEntity = getEscuelaByIdHelper(id);
        return convertToResquest(escuelaEntity);
    }

    @Override
    @Transactional
    public EscuelaResquest updateEscuela(@NonNull Integer id, @NonNull EscuelaResquest escuela) {
        EscuelaEntity escuelaEntity = getEscuelaByIdHelper(id);
        if (escuelaEntity != null) {
            escuelaEntity.setNombreEscuela(escuela.getNombreEscuela());
            FacultadEntity facultad = (FacultadEntity) facultadDao.findById(escuela.getFacultad().getIdFacultad()).orElseThrow();
            escuelaEntity.setFacultad(facultad);
            EscuelaEntity updateEscuela=escuelaDao.save(escuelaEntity);
            return convertToResquest(updateEscuela);
        }
        return null;
    }

    @Override
    @Transactional
    public EscuelaResquest delete(@NonNull Integer id) {
        EscuelaEntity escuelaEntity=getEscuelaByIdHelper(id);
        if(escuelaEntity!=null){
            escuelaEntity.setEstado(false);
            return convertToResquest(escuelaDao.save(escuelaEntity));
        }
        return null;
    }

    private EscuelaEntity getEscuelaByIdHelper(@NonNull Integer Id) {
        return escuelaDao.findById(Id).orElseThrow();
    }


    private EscuelaResquest convertToResquest(EscuelaEntity escuelaEntity) {
        return mapper.map(escuelaEntity, EscuelaResquest.class);
    }

    private EscuelaEntity convertToEntity(EscuelaResquest escuelaResquest) {
        return mapper.map(escuelaResquest, EscuelaEntity.class);
    }
}
