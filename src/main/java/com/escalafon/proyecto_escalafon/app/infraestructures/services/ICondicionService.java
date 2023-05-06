package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.models.resquests.CategoriaResquest;
import com.escalafon.proyecto_escalafon.app.models.resquests.CondicionResquest;
import lombok.NonNull;

import java.util.List;

public interface ICondicionService {
    public List<CondicionResquest> findAll();

    public CondicionResquest save(@NonNull CondicionResquest condicion);

    public CondicionResquest findOne(@NonNull Integer id);

    public CondicionResquest updateCondicion(@NonNull Integer id, @NonNull CondicionResquest condicion);

    public CondicionResquest delete(@NonNull Integer id);
}
