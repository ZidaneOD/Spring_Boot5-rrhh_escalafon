package com.escalafon.proyecto_escalafon.app.models.resquests;

import java.util.List;

import com.escalafon.proyecto_escalafon.app.models.entitys.RegimenPensionEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data

public class AfpResquest {
    @JsonProperty("idAFP")
    private Integer idAFP;
    @JsonProperty("nombreAFP")
    private String nombreAFP;
    @JsonProperty("regimen")
    private List<RegimenPensionEntity> regimenEntityList;
}
