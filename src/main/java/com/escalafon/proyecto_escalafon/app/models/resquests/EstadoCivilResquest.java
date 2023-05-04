package com.escalafon.proyecto_escalafon.app.models.resquests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class EstadoCivilResquest {
    @JsonProperty("idEstadoCivil")
    private Integer idEstadoCivil;
    @JsonProperty("nombreEstado")
    private String nombreEstado;
    @JsonProperty("estado")
    private String estado;
}
