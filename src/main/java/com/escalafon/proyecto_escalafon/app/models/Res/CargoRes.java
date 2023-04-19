package com.escalafon.proyecto_escalafon.app.models.Res;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CargoRes {
    @JsonProperty("idCargo")
    private Integer idCargo;
    @JsonProperty("tipoCargo")
    private String tipoCargo;
    @JsonProperty("estado")
    private boolean estado;
}
