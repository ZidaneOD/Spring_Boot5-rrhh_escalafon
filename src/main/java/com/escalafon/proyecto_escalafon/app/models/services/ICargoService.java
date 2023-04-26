package com.escalafon.proyecto_escalafon.app.models.services;
import com.escalafon.proyecto_escalafon.app.models.res.CargoRes;
import lombok.NonNull;

import java.util.List;
public interface ICargoService {

    public List<CargoRes> findAll();

    public CargoRes save(@NonNull CargoRes cargo);

    public CargoRes finOne(@NonNull  Integer id);
    public CargoRes updateCargo(@NonNull Integer id, @NonNull CargoRes cargoRes);
    public void delete(@NonNull Integer id);


}
