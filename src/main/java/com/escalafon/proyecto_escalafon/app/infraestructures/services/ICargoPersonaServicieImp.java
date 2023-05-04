package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escalafon.proyecto_escalafon.app.infraestructures.dao.ICargoPersonaDao;
import com.escalafon.proyecto_escalafon.app.models.entitys.CargoPersonaEntity;
import com.escalafon.proyecto_escalafon.app.models.resquests.CargoPersonaResquest;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@Component("ICargoPersonaServiceImp")
@AllArgsConstructor
public class ICargoPersonaServicieImp implements ICargoPersonaServicie{

    private final ICargoPersonaDao cargoPersonaDao;
    public static final ModelMapper mapper = new ModelMapper();


    @Override
    @Transactional(readOnly = true)
    public List<CargoPersonaResquest> findAllCargoPersona() {
        final List<CargoPersonaEntity> cargoPersonaEntity = cargoPersonaDao.findAllByEstadoIsTrue();
        return cargoPersonaEntity.stream().map(this::convertToResquest)
                .collect(Collectors.toList());
    }

    @Override
    public CargoPersonaResquest saveCargoPersona(@NonNull CargoPersonaResquest cargoPersonaResquest) {
        try {

            CargoPersonaEntity cargoPersonaEntity = convertToEntity(cargoPersonaResquest);
            //CargoPersonaEntity.setEstado(true);

            CargoPersonaEntity savedCargoPersona = cargoPersonaDao.save(cargoPersonaEntity);
            return convertToResquest(savedCargoPersona);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CargoPersonaResquest findOneCargoPersona(@NonNull Integer idCargoPersona) {
        final CargoPersonaEntity cargoPersonaEntity = getCargoPersonaByIdHelper(idCargoPersona);
        return convertToResquest(cargoPersonaEntity);
    }

    @Override
    public CargoPersonaResquest updateCargoPersona(@NonNull Integer idCargoPersona,
            @NonNull CargoPersonaResquest cargoPersonaResquest) {
                CargoPersonaEntity cargoPersonaEntity= getCargoPersonaByIdHelper(idCargoPersona);
                if(cargoPersonaEntity!=null){
                    cargoPersonaEntity.setCargoPersona(cargoPersonaResquest.getCargoPersona());
                    CargoPersonaEntity updateCargoPersona= cargoPersonaDao.save(cargoPersonaEntity);
                    return convertToResquest(updateCargoPersona);
                }
                return null;
    }

    @Override
    public CargoPersonaResquest deleteCargoPersona(@NonNull Integer idCargoPersona) {
        CargoPersonaEntity cargoPersonaEntity = getCargoPersonaByIdHelper(idCargoPersona);
        if(cargoPersonaEntity!=null){
            cargoPersonaEntity.setEstado(false);
           return convertToResquest(cargoPersonaDao.save(cargoPersonaEntity));
        }
        return null;
    }
    
    private CargoPersonaEntity getCargoPersonaByIdHelper(@NonNull Integer idCargoPersona) {
        return cargoPersonaDao.findById(idCargoPersona)
                .orElseThrow();


    }


    private CargoPersonaResquest convertToResquest(CargoPersonaEntity cargoPersonaEntity) {
        return mapper.map(cargoPersonaEntity, CargoPersonaResquest.class);
    }

    private CargoPersonaEntity convertToEntity(CargoPersonaResquest cargoPersonaResquest) {
        return mapper.map(cargoPersonaResquest, CargoPersonaEntity.class);
    }
}
