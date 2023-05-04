package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import java.util.List;

import com.escalafon.proyecto_escalafon.app.models.resquests.CargoPersonaResquest;

import lombok.NonNull;

public interface ICargoPersonaServicie {
    public List<CargoPersonaResquest> findAllCargoPersona();

    public CargoPersonaResquest saveCargoPersona(@NonNull CargoPersonaResquest cargo);

    public CargoPersonaResquest findOneCargoPersona(@NonNull Integer id);

    public CargoPersonaResquest updateCargoPersona(@NonNull Integer id, @NonNull CargoPersonaResquest CargoPersonaResquest);

    public CargoPersonaResquest deleteCargoPersona(@NonNull Integer id);
}
