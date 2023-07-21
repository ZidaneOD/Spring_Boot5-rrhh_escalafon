package com.escalafon.proyecto_escalafon.app.models.entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
@Table(name = "departamentos")
@Getter
@Setter
public class DepartamentoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento", nullable = false)
    private Integer idDepartamento;

    @NotEmpty
    @Max(150)
    @Column(name = "nombre_departamento",length = 150)
    private String nombreDepartamento;

    @NotNull
    private Boolean estado;
}
