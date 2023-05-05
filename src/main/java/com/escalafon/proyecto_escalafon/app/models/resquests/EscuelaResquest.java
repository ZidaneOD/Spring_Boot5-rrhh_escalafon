package com.escalafon.proyecto_escalafon.app.models.resquests;

import com.escalafon.proyecto_escalafon.app.models.entitys.FacultadEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class EscuelaResquest {
    @JsonProperty("codigo")
    private Integer idEscuela;
    @JsonProperty("escuela")
    private String nombreEscuela;
    @JsonProperty("facultad")
    private FacultadEntity facultad;
}
