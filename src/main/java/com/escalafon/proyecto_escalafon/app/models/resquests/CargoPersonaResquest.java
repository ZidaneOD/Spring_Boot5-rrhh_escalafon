package com.escalafon.proyecto_escalafon.app.models.resquests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CargoPersonaResquest {
    @JsonProperty("idcargopersona")
    private Integer idCargoPersona;
    @JsonProperty("cargopersona")
    private String cargoPersona;
    @JsonProperty("estado")
    private String estado;
}
