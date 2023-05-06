package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.models.resquests.CargoResquest;
import com.escalafon.proyecto_escalafon.app.models.resquests.CategoriaResquest;
import lombok.NonNull;

import java.util.List;

public interface ICategoriaService {
    public List<CategoriaResquest> findAll();

    public CategoriaResquest save(@NonNull CategoriaResquest categoria);

    public CategoriaResquest findOne(@NonNull Integer id);

    public CategoriaResquest updateCargo(@NonNull Integer id, @NonNull CategoriaResquest categoria);

    public CategoriaResquest delete(@NonNull Integer id);
}
