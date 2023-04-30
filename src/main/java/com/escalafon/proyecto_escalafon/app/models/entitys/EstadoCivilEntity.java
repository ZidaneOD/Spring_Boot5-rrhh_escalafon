package com.escalafon.proyecto_escalafon.app.models.entitys;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estadocivil")
@Setter @Getter
public class EstadoCivilEntity implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_estadocivil",nullable = false)
    private Integer idEstadoCivil;
    @NotNull
    @Column(name = "nombre_estado")
    private String nombreEstado;
    @NotNull
    private Boolean estado;
    private static final long serialVersionUID=1L;
    
}
