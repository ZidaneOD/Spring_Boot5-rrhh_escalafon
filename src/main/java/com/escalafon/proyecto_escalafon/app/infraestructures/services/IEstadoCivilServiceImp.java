package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.escalafon.proyecto_escalafon.app.infraestructures.dao.IEstadoCivilDao;
import com.escalafon.proyecto_escalafon.app.models.entitys.EstadoCivilEntity;
import com.escalafon.proyecto_escalafon.app.models.resquests.EstadoCivilResquest;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@Component("IEstadoCivilServiceImp")
@AllArgsConstructor
public class IEstadoCivilServiceImp implements IEstadoCivilService {


    private final IEstadoCivilDao estadoCivilDao;
    public static final ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public List<EstadoCivilResquest> finAllEstadoCivil() {
        final List<EstadoCivilEntity> estadoCivilEntity = estadoCivilDao.findAllByEstadoIsTrue();
        return estadoCivilEntity.stream().map(this::convertToResquest)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EstadoCivilResquest saveEstadoCivil(@NonNull EstadoCivilResquest estadoCivilResquest) {
        try {

            EstadoCivilEntity EstadoCivilEntity = convertToEntity(estadoCivilResquest);
            EstadoCivilEntity.setEstado(true);

            EstadoCivilEntity savedEstadoCivil = estadoCivilDao.save(EstadoCivilEntity);
            return convertToResquest(savedEstadoCivil);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public EstadoCivilResquest findOneEstadoCivil(@NonNull Integer idEstadoCivil) {
        final EstadoCivilEntity estadoCivilEntity = getEstadoCivilByIdHelper(idEstadoCivil);
        return convertToResquest(estadoCivilEntity);
    }
    

    
    @Override
    @Transactional
    public EstadoCivilResquest updateEstadoCivil(@NonNull Integer idEstadoCivil,
            @NonNull EstadoCivilResquest estadoCivilResquest) { 
                EstadoCivilEntity estadoCivilEntity= getEstadoCivilByIdHelper(idEstadoCivil);
                if(estadoCivilEntity!=null){
                    estadoCivilEntity.setNombreEstado(estadoCivilResquest.getNombreEstado());
                    EstadoCivilEntity updateCivilEntity= estadoCivilDao.save(estadoCivilEntity);
                    return convertToResquest(updateCivilEntity);
                }
                return null;
    }

    @Override
    @Transactional
    public EstadoCivilResquest deleteEstadoCivil(@NonNull Integer idEstadoCivil) {
        EstadoCivilEntity estadoCivilEntity = getEstadoCivilByIdHelper(idEstadoCivil);
        if(estadoCivilEntity!=null){
            estadoCivilEntity.setEstado(false);
           return convertToResquest(estadoCivilDao.save(estadoCivilEntity));
        }
        return null;
    }

    private EstadoCivilResquest convertToResquest(EstadoCivilEntity estadoCivilEntity) {
        return mapper.map(estadoCivilEntity, EstadoCivilResquest.class);
    }

    private EstadoCivilEntity convertToEntity(EstadoCivilResquest estadoCivilResquest) {
        return mapper.map(estadoCivilResquest, EstadoCivilEntity.class);
    }
    
    private EstadoCivilEntity getEstadoCivilByIdHelper(@NonNull Integer idEstadoCivil) {
        return estadoCivilDao.findById(idEstadoCivil)
        .orElseThrow();
    }

}
