package com.escalafon.proyecto_escalafon.app.models.entitys;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estadopersona")
@Getter
@Setter
public class EstadoPersonaEntity implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_estadopersona",nullable = false)
    private Integer idEstadoPersona;
    @NotEmpty
    @Max(30)
    @Column(name = "estado_persona", length = 30)
    private String estadoPersona;
    @NotNull
    private Boolean estado;
    private static final long serialVersionUID = 1L;
}
