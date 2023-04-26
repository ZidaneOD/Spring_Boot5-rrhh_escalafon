package com.escalafon.proyecto_escalafon.app.models.resquests;

import com.escalafon.proyecto_escalafon.app.models.entitys.CargoEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UsuarioResquest {
    @JsonProperty("id")
    private Integer idUsuario;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("apellidoPat")
    private String apellidoPat;
    @JsonProperty("apellidoMat")
    private String apellidoMat;
    @JsonProperty("fecha")
    private Date fechaNaci;
    @JsonProperty("correo")
    private String correo;
    @JsonProperty("login")
    private String login;
    @JsonProperty("pass")
    private String pass;
    @JsonProperty("cargo")
    private CargoEntity cargoResquest;
}
