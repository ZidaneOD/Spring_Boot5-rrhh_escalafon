package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.infraestructures.dao.IDedicacionDao;
import com.escalafon.proyecto_escalafon.app.models.entitys.CondicionEntity;
import com.escalafon.proyecto_escalafon.app.models.entitys.DedicacionEntity;
import com.escalafon.proyecto_escalafon.app.models.resquests.CondicionResquest;
import com.escalafon.proyecto_escalafon.app.models.resquests.DedicacionResquest;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Component("IDedicacionServiceImp")
@AllArgsConstructor
public class IDedicacionServiceImp implements IDedicacionService {
    private final IDedicacionDao dedicacionDao;
    private final static ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public List<DedicacionResquest> findAll() {
        final List<DedicacionEntity> dedicacionEntityList = dedicacionDao.findAllByEstadoIsTrue();
        return dedicacionEntityList.stream().map(this::convertToResquest).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DedicacionResquest save(@NonNull DedicacionResquest dedicacion) {
        try {
            DedicacionEntity dedicacionEntity = convertToEntity(dedicacion);
            dedicacionEntity.setEstado(true);
            DedicacionEntity savedDedicacion=dedicacionDao.save(dedicacionEntity);
            return convertToResquest(savedDedicacion);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public DedicacionResquest findOne(@NonNull Integer id) {
        final DedicacionEntity dedicacionEntity=getDedicacionByIdHelper(id);
        return convertToResquest(dedicacionEntity);
    }

    @Override
    @Transactional
    public DedicacionResquest updateDedicacion(@NonNull Integer id, @NonNull DedicacionResquest dedicacion) {
        DedicacionEntity dedicacionEntity=getDedicacionByIdHelper(id);
        if(dedicacionEntity!=null){
            dedicacionEntity.setTiempoDedicacion(dedicacion.getTiempoDedicacion());
            DedicacionEntity updateDedicacion=dedicacionDao.save(dedicacionEntity);
            return convertToResquest(updateDedicacion);
        }
        return null;
    }

    @Override
    @Transactional
    public DedicacionResquest delete(@NonNull Integer id) {
        DedicacionEntity dedicacionEntity=getDedicacionByIdHelper(id);
        if(dedicacionEntity!=null){
            dedicacionEntity.setEstado(false);
            DedicacionEntity deleteDedicacion=dedicacionDao.save(dedicacionEntity);
            return convertToResquest(deleteDedicacion);
        }
        return null;
    }

    private DedicacionEntity getDedicacionByIdHelper(@NonNull Integer Id) {
        return dedicacionDao.findById(Id).orElseThrow();
    }


    private DedicacionResquest convertToResquest(DedicacionEntity dedicacionEntity) {
        return mapper.map(dedicacionEntity, DedicacionResquest.class);
    }

    private DedicacionEntity convertToEntity(DedicacionResquest dedicacionResquest) {
        return mapper.map(dedicacionResquest, DedicacionEntity.class);
    }
}
