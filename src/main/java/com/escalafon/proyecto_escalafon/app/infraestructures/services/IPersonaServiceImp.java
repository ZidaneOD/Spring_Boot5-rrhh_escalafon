package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.infraestructures.dao.*;
import com.escalafon.proyecto_escalafon.app.models.entitys.*;
import com.escalafon.proyecto_escalafon.app.models.resquests.PersonaResquest;
import com.escalafon.proyecto_escalafon.app.models.resquests.UsuarioResquest;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Component("IPersonaServiceImp")
@AllArgsConstructor
public class IPersonaServiceImp implements IPersonaService{
    final private IPersonaDao personaDao;
    final ICargoDao cargoDao;
    final ICondicionDao condicionDao;
    final ICategoriaDao categoriaDao;
    final IEscuelaDao escuelaDao;
    final IDedicacionDao dedicacionDao;
    final IRegimenPensionDao regimenPensionDao;
    public static final ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public List<PersonaResquest> findAll() {
        final List<PersonaEntity> personaEntities=personaDao.findAllByEstadoIsTrue();
        return personaEntities.stream().map(this::convertToResquest).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PersonaResquest save(@NonNull PersonaResquest personaResquest) {
        try {
            PersonaEntity personaEntity = convertToEntity(personaResquest);
            CargoEntity cargoEntity = cargoDao.findById(personaEntity.getCargo().getId()).orElseThrow();
            CondicionEntity condicionEntity = condicionDao.findById(personaEntity.getCondicion().getIdCondicion()).orElseThrow();
            CategoriaEntity categoriaEntity = categoriaDao.findById(personaEntity.getCategoria().getIdCategoria()).orElseThrow();
            EscuelaEntity escuelaEntity = escuelaDao.findById(personaEntity.getEscuela().getIdEscuela()).orElseThrow();
            DedicacionEntity dedicacionEntity = dedicacionDao.findById(personaEntity.getDedicacion().getIdDedicacion()).orElseThrow();
            RegimenPensionEntity regimenPensionEntity = regimenPensionDao.findById(personaEntity.getRegimenPension().getIdRegimen()).orElseThrow();

            personaEntity.setCargo(cargoEntity);
            personaEntity.setCondicion(condicionEntity);
            personaEntity.setCategoria(categoriaEntity);
            personaEntity.setEscuela(escuelaEntity);
            personaEntity.setDedicacion(dedicacionEntity);
            personaEntity.setRegimenPension(regimenPensionEntity);

            PersonaEntity savedPersona = personaDao.save(personaEntity);
            return convertToResquest(savedPersona);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public PersonaResquest findOne(@NonNull Integer id) {
        final PersonaEntity personaEntity = getPersonaByIdHelper(id);
        return convertToResquest(personaEntity);
    }

    @Override
    @Transactional
    public PersonaResquest updatePersona(@NonNull Integer id, @NonNull PersonaResquest personaResquest) {

        return null;
    }

    @Override
    @Transactional
    public PersonaResquest delete(@NonNull Integer id) {
        PersonaEntity personaEntity = getPersonaByIdHelper(id);
        if (personaEntity != null) {
            personaEntity.setEstado(false);
        }
            return convertToResquest(personaDao.save(personaEntity));
        }

    private PersonaEntity getPersonaByIdHelper(@NonNull Integer id) {
        return personaDao.findById(id)
                .orElseThrow();
    }

    private PersonaResquest convertToResquest(PersonaEntity personaEntity) {
        return mapper.map(personaEntity, PersonaResquest.class);
    }

    private PersonaEntity convertToEntity(PersonaResquest personaResquest) {
        return mapper.map(personaResquest, PersonaEntity.class);
    }
}
