package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.models.resquests.EscuelaResquest;
import lombok.NonNull;

import java.util.List;

public interface IEscuelaService {
    public List<EscuelaResquest> findAll();

    public EscuelaResquest save(@NonNull EscuelaResquest escuela);

    public EscuelaResquest findOne(@NonNull Integer id);

    public EscuelaResquest updateEscuela(@NonNull Integer id, @NonNull EscuelaResquest escuela);

    public EscuelaResquest delete(@NonNull Integer id);
}
