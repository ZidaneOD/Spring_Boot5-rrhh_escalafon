package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.models.resquests.PersonaResquest;
import com.escalafon.proyecto_escalafon.app.models.resquests.UsuarioResquest;
import lombok.NonNull;

import java.util.List;

public interface IPersonaService {
    public List<PersonaResquest>findAll();

    public PersonaResquest save(@NonNull PersonaResquest personaResquest);

    public PersonaResquest findOne(@NonNull Integer id);

    public PersonaResquest updatePersona(@NonNull Integer id, @NonNull PersonaResquest personaResquest);

    public PersonaResquest delete(@NonNull Integer id);
}
