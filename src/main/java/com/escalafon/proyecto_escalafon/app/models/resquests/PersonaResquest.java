package com.escalafon.proyecto_escalafon.app.models.resquests;

import com.escalafon.proyecto_escalafon.app.models.entitys.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class PersonaResquest {
    @JsonProperty("id")
    private Integer idPersona;
    @JsonProperty("nombres")
    private String nombre;
    @JsonProperty("apellidoPat")
    private String apellidoPat;
    @JsonProperty("apellidoMat")
    private String apellidoMat;
    @JsonProperty("dni")
    private String dni;
    @JsonProperty("profesion")
    private String profesion;
    @JsonProperty("ingreso")
    private Date fechaIngre;
    @JsonProperty("nacimiento")
    private Date fechaNaci;
    @JsonProperty("domicilio")
    private String domicilio;
    @JsonProperty("correo")
    private String correo;
    @JsonProperty("celular")
    private String celular;
    @JsonProperty("hijos")
    private Integer hijos;
    @JsonProperty("estadoCivil")
    private Integer estadoCivil;
    @JsonProperty("condicion")
    private CondicionEntity condicion;
    @JsonProperty("cargo")
    private CargoEntity cargo;
    @JsonProperty("estadoPersona")
    private EstadoPersonaEntity estadoPersona;
    @JsonProperty("distrito")
    private DistritoEntity distrito;
    @JsonProperty("categoria")
    private CategoriaEntity categoria;
    @JsonProperty("dedicacion")
    private DedicacionEntity dedicacion;
    @JsonProperty("escuela")
    private EscuelaEntity escuela;
    @JsonProperty("regimenPension")
    private RegimenPensionEntity regimenPension;
}
