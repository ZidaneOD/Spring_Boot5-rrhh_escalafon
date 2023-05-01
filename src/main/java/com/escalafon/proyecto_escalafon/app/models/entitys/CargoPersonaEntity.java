package com.escalafon.proyecto_escalafon.app.models.entitys;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cargopersonas")
@Setter @Getter
public class CargoPersonaEntity implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_cargopersona",nullable = false)
    private Integer idEstadoPersona;
    @NotEmpty
    @Max(50)
    @Column(name = "cargo_persona", length = 50)
    private String cargoPersona;
    @NotNull
    private Boolean estado;
    private static final long serialVersionUID=1L;
}
