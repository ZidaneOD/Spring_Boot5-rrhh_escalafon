package com.escalafon.proyecto_escalafon.app.models.resquests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DedicacionResquest {
    @JsonProperty("codigo")
    private Integer idDedicacion;
    @JsonProperty("dedicacion")
    private String tiempoDedicacion;
}
