package com.escalafon.proyecto_escalafon.app.models.entitys;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estadociviles")
@Setter @Getter
public class EstadoCivilEntity implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_estadocivil",nullable = false)
    private Integer idEstadoCivil;
    @NotNull
    @Max(40)
    @Column(name = "nombre_estado",length = 40)
    private String nombreEstado;
    @NotNull
    private Boolean estado;
    private static final long serialVersionUID=1L;
    
}
