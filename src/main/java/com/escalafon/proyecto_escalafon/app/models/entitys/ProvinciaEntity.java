package com.escalafon.proyecto_escalafon.app.models.entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "provincia")
@Getter
@Setter
public class ProvinciaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_provincia", nullable = false)
    private Integer idProvincia;

    @Max(150)
    @Column(name = "nombre_provincia",length = 150)
    private String nombreProvincia;

    @NotNull
    private Boolean estado;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_provincia")
    private List<DistritoEntity> distritolist;
    //Eazy - por partes

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento")
    private DepartamentoEntity departamento;

}
