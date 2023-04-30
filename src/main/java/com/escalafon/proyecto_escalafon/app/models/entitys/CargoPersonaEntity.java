package com.escalafon.proyecto_escalafon.app.models.entitys;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cargopersona")
@Setter @Getter
public class CargoPersonaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_cargopersona",nullable = false)
    private Integer idEstadoPersona;
    @NotEmpty
    @Max(50)
    @Column(name = "cargo_persona", length = 50)
    private String cargoPersona;
    @NotNull
    private Boolean estado;
    
}
