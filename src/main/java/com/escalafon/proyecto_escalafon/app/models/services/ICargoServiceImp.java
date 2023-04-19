package com.escalafon.proyecto_escalafon.app.models.services;

import com.escalafon.proyecto_escalafon.app.models.Res.CargoRes;
import com.escalafon.proyecto_escalafon.app.models.entity.Cargo;
import com.escalafon.proyecto_escalafon.app.models.dao.ICargoDao;
import com.escalafon.proyecto_escalafon.app.models.entity.Usuario;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component("ICargoServiceImp")
public class ICargoServiceImp implements ICargoService {

    @Autowired
    private ICargoDao cargoDao;
    public static final ModelMapper mapper = new ModelMapper();
    @Override
    @Transactional(readOnly = true)
    public List<CargoRes> findAll() {

        final List<Cargo> cargos = cargoDao.findAllByEstadoIsTrue();
        return cargos.stream().map(this::convertToRest)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CargoRes save(CargoRes cargoRes) {

        try {
            Cargo CargoEntity = convertToEntity(cargoRes);
            Cargo savedDoctor = cargoDao.save(CargoEntity);
            return convertToRest(savedDoctor);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public CargoRes finOne(@NonNull final Integer id) {
        final Cargo cargo = getCargoByIdHelper(id);
        return convertToRest(cargo);
    }

    @Override
    public CargoRes updateCargo(@NonNull Integer id, @NonNull CargoRes cargoRes) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        cargoDao.deleteById(id);
    }

    private Cargo getCargoByIdHelper(@NonNull Integer Id) {
        return cargoDao.findById(Id)
                .orElseThrow();
    }


    public CargoRes convertToRest(Cargo cargo) {
        return mapper.map(cargo, CargoRes.class);
    }

    public Cargo convertToEntity(CargoRes doctorRest) {
        return mapper.map(doctorRest, Cargo.class);
    }
}
