package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.infraestructures.dao.ICondicionDao;
import com.escalafon.proyecto_escalafon.app.models.entitys.CondicionEntity;
import com.escalafon.proyecto_escalafon.app.models.resquests.CondicionResquest;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Component("ICondicionServiceImp")
@AllArgsConstructor
public class ICondicionServiceImp implements ICondicionService {
    private final ICondicionDao condicionDao;
    private final static ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public List<CondicionResquest> findAll() {
        final List<CondicionEntity> condicionEntityList = condicionDao.findAllByEstadoIsTrue();
        return condicionEntityList.stream().map(this::convertToResquest).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CondicionResquest save(@NonNull CondicionResquest condicion) {
        try {
            CondicionEntity condicionEntity = convertToEntity(condicion);
            condicionEntity.setEstado(true);
            CondicionEntity savedCondicion = condicionDao.save(condicionEntity);
            return convertToResquest(savedCondicion);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public CondicionResquest findOne(@NonNull Integer id) {
        final CondicionEntity condicionEntity = getCondicionByIdHelper(id);
        return convertToResquest(condicionEntity);
    }

    @Override
    @Transactional
    public CondicionResquest updateCondicion(@NonNull Integer id, @NonNull CondicionResquest condicion) {
        CondicionEntity condicionEntity = getCondicionByIdHelper(id);
        if (condicionEntity != null) {
            condicionEntity.setTipoCondicion(condicion.getTipoCondicion());
            CondicionEntity updateCondicion = condicionDao.save(condicionEntity);
            return convertToResquest(updateCondicion);
        }
        return null;
    }

    @Override
    @Transactional
    public CondicionResquest delete(@NonNull Integer id) {
        CondicionEntity condicionEntity = getCondicionByIdHelper(id);
        if (condicionEntity != null) {
            condicionEntity.setEstado(false);
            CondicionEntity deleteCondicion = condicionDao.save(condicionEntity);
            return convertToResquest(deleteCondicion);
        }
        return null;
    }

    private CondicionEntity getCondicionByIdHelper(@NonNull Integer Id) {
        return condicionDao.findById(Id).orElseThrow();
    }


    private CondicionResquest convertToResquest(CondicionEntity condicionEntity) {
        return mapper.map(condicionEntity, CondicionResquest.class);
    }

    private CondicionEntity convertToEntity(CondicionResquest condicionResquest) {
        return mapper.map(condicionResquest, CondicionEntity.class);
    }
}
