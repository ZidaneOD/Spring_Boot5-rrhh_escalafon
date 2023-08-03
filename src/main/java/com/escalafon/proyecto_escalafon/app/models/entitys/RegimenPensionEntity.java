package com.escalafon.proyecto_escalafon.app.models.entitys;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "regimenpensiones")
@Getter
@Setter
public class RegimenPensionEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_regimen", nullable = false)
    private Integer idRegimen;
    @NotEmpty
    @Max(150)
    @Column(name = "nombre_regimen", length = 150)
    private String nombreRegimen;
    @NonNull
    private Boolean estado;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "regimenPensionEntityList")
    private List<AfpEntity> afps;
    private static final long serialVersionUID = 1L;
}
