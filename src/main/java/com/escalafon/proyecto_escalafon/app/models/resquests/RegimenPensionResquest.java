package com.escalafon.proyecto_escalafon.app.models.resquests;

import com.escalafon.proyecto_escalafon.app.models.entitys.AfpEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RegimenPensionResquest {
    @JsonProperty("idRegimen")
    private Integer idRegimen;
    @JsonProperty("nombreRegimen")
    private String nombreRegimen;
    @JsonProperty("afp")
    private List<AfpEntity> afp;
}
