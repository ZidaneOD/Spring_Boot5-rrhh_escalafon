package com.escalafon.proyecto_escalafon.app.models.entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "departamento")
@Getter
@Setter
public class DepartamentoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento", nullable = false)
    private Integer idDepartamento;

    @Max(150)
    @Column(name = "nombre_departamento",length = 150)
    private String nombreDepartamento;

    @NotNull
    private Boolean estado;

    @OneToMany (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento")
    private List<ProvinciaEntity> provincialist;
}
