package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.models.resquests.FacultadResquest;
import lombok.NonNull;

import java.util.List;

public interface IFacultadService {

    public List<FacultadResquest> findAll();

    public FacultadResquest save(@NonNull FacultadResquest facultad);

    public FacultadResquest findOne(@NonNull Integer id);

    public FacultadResquest updateFacultad(@NonNull Integer id, @NonNull FacultadResquest facultad);

    public FacultadResquest delete(@NonNull Integer id);
}
