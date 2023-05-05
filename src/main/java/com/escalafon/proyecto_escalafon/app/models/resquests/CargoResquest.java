package com.escalafon.proyecto_escalafon.app.models.resquests;

import com.escalafon.proyecto_escalafon.app.models.entitys.UsuarioEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CargoResquest {
    @JsonProperty("id")
    private Integer idCargo;
    @JsonProperty("tipoCargo")
    private String tipoCargo;
}
