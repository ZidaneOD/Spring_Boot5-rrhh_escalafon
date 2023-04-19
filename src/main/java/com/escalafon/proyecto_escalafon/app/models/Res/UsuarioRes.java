package com.escalafon.proyecto_escalafon.app.models.Res;

import com.escalafon.proyecto_escalafon.app.models.entity.Cargo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UsuarioRes {
    @JsonProperty("idUsuario")
    private Integer idUsuario;
    @JsonProperty("apellidoPat")
    private String apellidoPat;
    @JsonProperty("apellidoMat")
    private String apellidoMat;
    @JsonProperty("fechaNaci")
    private Date fechaNaci;
    @JsonProperty("correo")
    private String correo;
    @JsonProperty("login")
    private String login;
    @JsonProperty("pass")
    private String pass;
    @JsonProperty("estado")
    private boolean estado;
    @JsonProperty("cargo")
    private Cargo cargo;
}
