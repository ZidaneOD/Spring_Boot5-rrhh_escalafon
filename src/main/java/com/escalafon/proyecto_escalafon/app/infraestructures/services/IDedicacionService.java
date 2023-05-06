package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.models.resquests.CategoriaResquest;
import com.escalafon.proyecto_escalafon.app.models.resquests.DedicacionResquest;
import lombok.NonNull;

import java.util.List;

public interface IDedicacionService{
    public List<DedicacionResquest> findAll();

    public DedicacionResquest save(@NonNull DedicacionResquest dedicacion);

    public DedicacionResquest findOne(@NonNull Integer id);

    public DedicacionResquest updateDedicacion(@NonNull Integer id, @NonNull DedicacionResquest dedicacion);

    public DedicacionResquest delete(@NonNull Integer id);
}
