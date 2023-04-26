package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.models.resquests.CargoResquest;
import lombok.NonNull;

import java.util.List;

public interface ICargoService {

    public List<CargoResquest> findAll();

    public CargoResquest save(@NonNull CargoResquest cargo);

    public CargoResquest findOne(@NonNull Integer id);

    public CargoResquest updateCargo(@NonNull Integer id, @NonNull CargoResquest cargoResquest);

    public CargoResquest delete(@NonNull Integer id);


}
