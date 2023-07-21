package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import java.util.List;
import com.escalafon.proyecto_escalafon.app.models.resquests.RegimenPensionResquest;
import lombok.NonNull;

public interface IRegimenPensionService {
    public List<RegimenPensionResquest> findAllRegimenPension();

    public RegimenPensionResquest saveRegimenPension(@NonNull RegimenPensionResquest RegimenPension);

    public RegimenPensionResquest findOneRegimenPension(@NonNull Integer id);

    public RegimenPensionResquest updateRegimenPension(@NonNull Integer id, @NonNull RegimenPensionResquest RegimenPension);

    public RegimenPensionResquest deleteRegimenPension(@NonNull Integer id);
}
