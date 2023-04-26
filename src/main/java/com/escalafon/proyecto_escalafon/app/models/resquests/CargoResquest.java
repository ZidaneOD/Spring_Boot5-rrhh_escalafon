package com.escalafon.proyecto_escalafon.app.models.resquests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CargoResquest {
    @JsonProperty("id")
    private Integer idCargo;
    @JsonProperty("tipoCargo")
    private String tipoCargo;
}
