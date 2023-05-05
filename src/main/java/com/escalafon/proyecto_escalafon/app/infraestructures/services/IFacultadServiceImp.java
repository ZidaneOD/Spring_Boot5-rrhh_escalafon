package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.infraestructures.dao.IFacultadDao;
import com.escalafon.proyecto_escalafon.app.models.entitys.FacultadEntity;
import com.escalafon.proyecto_escalafon.app.models.resquests.FacultadResquest;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Component("IFacultadServiceImp")
@AllArgsConstructor
public class IFacultadServiceImp implements IFacultadService {
    private final IFacultadDao facultadDao;
    public static final ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public List<FacultadResquest> findAll() {
        final List<FacultadEntity> facultadEntityList = facultadDao.findAllByEstadoIsTrue();
        return facultadEntityList.stream().map(this::convertToResquest).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public FacultadResquest save(@NonNull FacultadResquest facultad) {
        try {
            FacultadEntity facultadEntity = convertToEntity(facultad);
            facultadEntity.setEstado(true);
            FacultadEntity savedFacultad = facultadDao.save(facultadEntity);
            return convertToResquest(savedFacultad);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public FacultadResquest findOne(@NonNull Integer id) {
        final FacultadEntity facultadEntity = getFacultadByIdHelper(id);
        return convertToResquest(facultadEntity);
    }

    @Override
    @Transactional
    public FacultadResquest updateFacultad(@NonNull Integer id, @NonNull FacultadResquest facultad) {
        FacultadEntity facultadEntity = getFacultadByIdHelper(id);
        if (facultadEntity != null) {
            facultadEntity.setNombreFacultad(facultad.getNombreFacultad());
            FacultadEntity updateFacultad = facultadDao.save(facultadEntity);
            return convertToResquest(updateFacultad);
        }
        return null;
    }

    @Override
    @Transactional
    public FacultadResquest delete(@NonNull Integer id) {
        FacultadEntity facultadEntity = getFacultadByIdHelper(id);
        if (facultadEntity != null) {
            facultadEntity.setEstado(false);
            FacultadEntity updateFacultad = facultadDao.save(facultadEntity);
            return convertToResquest(updateFacultad);
        }
        return null;
    }

    private FacultadEntity getFacultadByIdHelper(@NonNull Integer id) {
        return facultadDao.findById(id).orElseThrow();
    }

    public FacultadResquest convertToResquest(FacultadEntity facultadEntity) {
        return mapper.map(facultadEntity, FacultadResquest.class);
    }

    public FacultadEntity convertToEntity(FacultadResquest facultadResquest) {
        return mapper.map(facultadResquest, FacultadEntity.class);
    }
}
