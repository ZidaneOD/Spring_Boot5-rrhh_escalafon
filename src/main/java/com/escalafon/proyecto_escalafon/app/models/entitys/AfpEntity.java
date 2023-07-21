package com.escalafon.proyecto_escalafon.app.models.entitys;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "afps")
@Getter @Setter
public class AfpEntity implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_afp",nullable = false)
    private Integer idAFP;
    @NotEmpty
    @Max(150)
    @Column(name = "nombre_afp",length = 150)
    private String nombreAFP;
    @NotNull
    private Boolean estado;

    
    @NotNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "afps")
    private List<RegimenPensionEntity> regimenPensionEntityList;

}
