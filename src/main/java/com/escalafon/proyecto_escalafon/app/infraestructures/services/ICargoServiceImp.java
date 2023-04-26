package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.infraestructures.dao.ICargoDao;
import com.escalafon.proyecto_escalafon.app.models.entitys.CargoEntity;
import com.escalafon.proyecto_escalafon.app.models.resquests.CargoResquest;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Component("ICargoServiceImp")
@AllArgsConstructor
public class ICargoServiceImp implements ICargoService {

    private final ICargoDao cargoDao;
    public static final ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public List<CargoResquest> findAll() {
        final List<CargoEntity> cargoEntity = cargoDao.findAllByEstadoIsTrue();
        return cargoEntity.stream().map(this::convertToResquest)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CargoResquest save(CargoResquest cargoResquest) {
        try {

            CargoEntity CargoEntity = convertToEntity(cargoResquest);
            CargoEntity.setEstado(true);

            CargoEntity savedCargo = cargoDao.save(CargoEntity);
            return convertToResquest(savedCargo);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public CargoResquest findOne(@NonNull final Integer id) {
        final CargoEntity cargoEntity = getCargoByIdHelper(id);
        return convertToResquest(cargoEntity);
    }

    @Override
    public CargoResquest updateCargo(@NonNull Integer id, @NonNull CargoResquest cargoResquest) {
        CargoEntity cargoEntity= getCargoByIdHelper(id);
        if(cargoEntity!=null){
            cargoEntity.setTipoCargo(cargoResquest.getTipoCargo());
            CargoEntity updateCargo= cargoDao.save(cargoEntity);
            return convertToResquest(updateCargo);
        }
        return null;
    }

    @Override
    @Transactional
    public CargoResquest delete(@NonNull Integer id) {
        CargoEntity cargoEntity = getCargoByIdHelper(id);
        if(cargoEntity!=null){
            cargoEntity.setEstado(false);
           return convertToResquest(cargoDao.save(cargoEntity));
        }
        return null;
    }

    private CargoEntity getCargoByIdHelper(@NonNull Integer Id) {
        return cargoDao.findById(Id)
                .orElseThrow();


    }


    private CargoResquest convertToResquest(CargoEntity cargoEntity) {
        return mapper.map(cargoEntity, CargoResquest.class);
    }

    private CargoEntity convertToEntity(CargoResquest cargoResquest) {
        return mapper.map(cargoResquest, CargoEntity.class);
    }
}
