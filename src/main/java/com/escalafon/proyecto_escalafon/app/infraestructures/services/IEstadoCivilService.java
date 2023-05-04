package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import java.util.List;

import com.escalafon.proyecto_escalafon.app.models.resquests.EstadoCivilResquest;

import lombok.NonNull;

public interface IEstadoCivilService {
    public List<EstadoCivilResquest> finAllEstadoCivil();

    public EstadoCivilResquest saveEstadoCivil(@NonNull EstadoCivilResquest EstadoCivil);

    public EstadoCivilResquest findOneEstadoCivil(@NonNull Integer idEstadoCivil);

    public EstadoCivilResquest updateEstadoCivil(@NonNull Integer idEstadoCivil, @NonNull EstadoCivilResquest estadoCivilResquest);

    public EstadoCivilResquest deleteEstadoCivil(@NonNull Integer idEstadoCivil);
}
