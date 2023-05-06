package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import com.escalafon.proyecto_escalafon.app.infraestructures.dao.ICategoriaDao;
import com.escalafon.proyecto_escalafon.app.models.entitys.CargoEntity;
import com.escalafon.proyecto_escalafon.app.models.entitys.CategoriaEntity;
import com.escalafon.proyecto_escalafon.app.models.resquests.CargoResquest;
import com.escalafon.proyecto_escalafon.app.models.resquests.CategoriaResquest;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Component("ICategoriaServiceImp")
@AllArgsConstructor
public class ICategoriaServiceImp implements ICategoriaService {
    private final ICategoriaDao categoriaDao;
    private static final ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaResquest> findAll() {
        final List<CategoriaEntity> categoriaEntity=categoriaDao.findByEstadoIsTrue();
        return categoriaEntity.stream().map(this::convertToResquest).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CategoriaResquest save(@NonNull CategoriaResquest categoria) {

        try {
            CategoriaEntity categoriaEntity=convertToEntity(categoria);
            categoriaEntity.setEstado(true);
            CategoriaEntity savedCategoria=categoriaDao.save(categoriaEntity);
            return convertToResquest(savedCategoria);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public CategoriaResquest findOne(@NonNull Integer id) {
        final CategoriaEntity categoriaEntity=getCategoriaByIdHelper(id);
        return convertToResquest(categoriaEntity);
    }

    @Override
    @Transactional
    public CategoriaResquest updateCargo(@NonNull Integer id, @NonNull CategoriaResquest categoria) {
        CategoriaEntity categoriaEntity=getCategoriaByIdHelper(id);
        if(categoriaEntity!=null){
            categoriaEntity.setTipoCategoria(categoria.getTipoCategoria());
            CategoriaEntity updateCategoria=categoriaDao.save(categoriaEntity);
            return convertToResquest(updateCategoria);
        }
        return null;
    }

    @Override
    @Transactional
    public CategoriaResquest delete(@NonNull Integer id) {
        CategoriaEntity categoriaEntity=getCategoriaByIdHelper(id);
        if(categoriaEntity!=null){
            categoriaEntity.setEstado(false);
            return convertToResquest(categoriaDao.save(categoriaEntity));
        }
        return null;
    }

    private CategoriaEntity getCategoriaByIdHelper(@NonNull Integer Id) {
        return categoriaDao.findById(Id).orElseThrow();
    }


    private CategoriaResquest convertToResquest(CategoriaEntity categoriaEntity) {
        return mapper.map(categoriaEntity, CategoriaResquest.class);
    }

    private CategoriaEntity convertToEntity(CategoriaResquest categoriaResquest) {
        return mapper.map(categoriaResquest, CategoriaEntity.class);
    }
}
