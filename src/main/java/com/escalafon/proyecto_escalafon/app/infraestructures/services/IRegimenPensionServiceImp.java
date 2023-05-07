package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.escalafon.proyecto_escalafon.app.infraestructures.dao.IAfpDao;
import com.escalafon.proyecto_escalafon.app.infraestructures.dao.IRegimenPensionDao;
import com.escalafon.proyecto_escalafon.app.models.entitys.AfpEntity;
import com.escalafon.proyecto_escalafon.app.models.entitys.RegimenPensionEntity;
import com.escalafon.proyecto_escalafon.app.models.resquests.RegimenPensionResquest;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@Component("IRegimenPensionServiceImp")
@AllArgsConstructor

public class IRegimenPensionServiceImp implements IRegimenPensionService{
    private final IRegimenPensionDao regimenPensionDao;
    private final IAfpDao afpDao;
    public static final ModelMapper mapper = new ModelMapper();

    @Override
    public List<RegimenPensionResquest> findAllRegimenPension() {
        final List<RegimenPensionEntity> regimenPensionEntity = regimenPensionDao.findAllByEstadoIsTrue();
        return regimenPensionEntity.stream().map(this::convertToResquest).collect(Collectors.toList());
    }

    @Override
    public RegimenPensionResquest saveRegimenPension(@NonNull RegimenPensionResquest regimenPension) {
        try {
            RegimenPensionEntity regimenPensionEntity = convertToEntity(regimenPension);
            AfpEntity afpEntity=afpDao.findById(regimenPension.getIdRegimen()).orElseThrow();
            regimenPensionEntity.setEstado(true);
            regimenPensionEntity.setAfps(afpEntity);
            RegimenPensionEntity savedRegimenPension = regimenPensionDao.save(regimenPensionEntity);
            return convertToResquest(savedRegimenPension);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public RegimenPensionResquest findOneRegimenPension(@NonNull Integer id) {
        final RegimenPensionEntity regimenPensionEntity = getRegimenPensionByIdHelper(id);
        return convertToResquest(regimenPensionEntity);
    }

    @Override
    public RegimenPensionResquest updateRegimenPension(@NonNull Integer id,
            @NonNull RegimenPensionResquest regimenPension) {
                RegimenPensionEntity regimenPensionEntity = getRegimenPensionByIdHelper(id);
                if (regimenPensionEntity != null) {
                    regimenPensionEntity.setNombreRegimen(regimenPension.getNombreRegimen());
                    AfpEntity afp = (AfpEntity) afpDao.findById(regimenPension.getAfp().getIdAFP()).orElseThrow();
                    regimenPensionEntity.setAfps(afp);
                    RegimenPensionEntity updateRegimenPension=regimenPensionDao.save(regimenPensionEntity);
                    return convertToResquest(updateRegimenPension);
                }
                return null;
    }

    @Override
    public RegimenPensionResquest deleteRegimenPension(@NonNull Integer id) {
        RegimenPensionEntity regimenPensionEntity=getRegimenPensionByIdHelper(id);
        if(regimenPensionEntity!=null){
            regimenPensionEntity.setEstado(false);
            return convertToResquest(regimenPensionDao.save(regimenPensionEntity));
        }
        return null;
    }

    private RegimenPensionEntity getRegimenPensionByIdHelper(@NonNull Integer Id) {
        return regimenPensionDao.findById(Id).orElseThrow();
    }


    private RegimenPensionResquest convertToResquest(RegimenPensionEntity regimenPensionEntity) {
        return mapper.map(regimenPensionEntity, RegimenPensionResquest.class);
    }

    private RegimenPensionEntity convertToEntity(RegimenPensionResquest regimenPensionResquest) {
        return mapper.map(regimenPensionResquest, RegimenPensionEntity.class);
    }
    
}
