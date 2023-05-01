package com.escalafon.proyecto_escalafon.app.models.entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "provincias")
@Getter
@Setter
public class ProvinciaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_provincia", nullable = false)
    private Integer idProvincia;

    @NotEmpty
    @Max(150)
    @Column(name = "nombre_provincia", length = 150)
    private String nombreProvincia;

    @NotNull
    private Boolean estado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    private DepartamentoEntity departamento;

}
