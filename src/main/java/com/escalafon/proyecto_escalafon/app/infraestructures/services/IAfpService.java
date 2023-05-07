package com.escalafon.proyecto_escalafon.app.infraestructures.services;

import java.util.List;

import com.escalafon.proyecto_escalafon.app.models.resquests.AfpResquest;

import lombok.NonNull;

public interface IAfpService {
    public List<AfpResquest> findAllAfp();

    public AfpResquest saveAfp(@NonNull AfpResquest Afp);

    public AfpResquest findOneAfp(@NonNull Integer id);

    public AfpResquest updateAfp(@NonNull Integer id, @NonNull AfpResquest Afp);

    public AfpResquest deleteAfp(@NonNull Integer id);
}
