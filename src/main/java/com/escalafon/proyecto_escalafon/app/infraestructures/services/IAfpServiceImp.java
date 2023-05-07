package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escalafon.proyecto_escalafon.app.infraestructures.dao.IAfpDao;
import com.escalafon.proyecto_escalafon.app.models.entitys.AfpEntity;
import com.escalafon.proyecto_escalafon.app.models.resquests.AfpResquest;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@Component("IAfpServiceImp")
@AllArgsConstructor

public class IAfpServiceImp implements IAfpService{
    private final IAfpDao afpDao;
    public static final ModelMapper mapper = new ModelMapper();
    @Override
    @Transactional(readOnly = true)
    public List<AfpResquest> findAllAfp() {
        final List<AfpEntity> afpEntityList = afpDao.findAllByEstadoIsTrue();
        return afpEntityList.stream().map(this::convertToResquest).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public AfpResquest saveAfp(@NonNull AfpResquest Afp) {
        try {
            AfpEntity AfpEntity = convertToEntity(Afp);
            AfpEntity.setEstado(true);
            AfpEntity savedAfp = afpDao.save(AfpEntity);
            return convertToResquest(savedAfp);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    @Transactional
    public AfpResquest findOneAfp(@NonNull Integer id) {
        final AfpEntity AfpEntity = getAfpByIdHelper(id);
        return convertToResquest(AfpEntity);
    }
    @Override
    @Transactional
    public AfpResquest updateAfp(@NonNull Integer id, @NonNull AfpResquest Afp) {
        AfpEntity AfpEntity = getAfpByIdHelper(id);
        if (AfpEntity != null) {
            AfpEntity.setNombreAFP(Afp.getNombreAFP());
            AfpEntity updateAfp = afpDao.save(AfpEntity);
            return convertToResquest(updateAfp);
        }
        return null;
    }
    @Override
    @Transactional
    public AfpResquest deleteAfp(@NonNull Integer id) {
        AfpEntity AfpEntity = getAfpByIdHelper(id);
        if (AfpEntity != null) {
            AfpEntity.setEstado(false);
            AfpEntity updateAfp = afpDao.save(AfpEntity);
            return convertToResquest(updateAfp);
        }
        return null;
    }
    private AfpEntity getAfpByIdHelper(@NonNull Integer id) {
        return afpDao.findById(id).orElseThrow();
    }

    public AfpResquest convertToResquest(AfpEntity AfpEntity) {
        return mapper.map(AfpEntity, AfpResquest.class);
    }

    public AfpEntity convertToEntity(AfpResquest AfpResquest) {
        return mapper.map(AfpResquest, AfpEntity.class);
    }
}
