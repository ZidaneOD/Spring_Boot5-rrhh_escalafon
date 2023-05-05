package com.escalafon.proyecto_escalafon.app.models.resquests;

import com.escalafon.proyecto_escalafon.app.models.entitys.EscuelaEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class FacultadResquest {
    @JsonProperty("codigo")
    private Integer idFacultad;
    @JsonProperty("facultad")
    private String nombreFacultad;
    @JsonProperty("escuelas")
    private List<EscuelaEntity> escuelaEntityList;
}
