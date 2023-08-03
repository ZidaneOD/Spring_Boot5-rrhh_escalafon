package com.escalafon.proyecto_escalafon.app.models.entitys;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "facultades")
@Getter
@Setter
public class FacultadEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_facultad", nullable = false)
    private Integer idFacultad;
    @NotEmpty
    @Max(100)
    @Column(name = "nombre_facultad", length = 100)
    private String nombreFacultad;
    @NonNull
    private Boolean estado;
    private static final long serialVersionUID = 1L;
}
