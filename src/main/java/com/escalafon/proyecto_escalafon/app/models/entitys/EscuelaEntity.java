package com.escalafon.proyecto_escalafon.app.models.entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "escuelas")
@Getter @Setter
public class EscuelaEntity implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_escuela",nullable = false)
    private Integer idEscuela;
    @NotEmpty
    @Max(100)
    @Column(name = "nombre_escuela",length = 100)
    private String nombreEscuela;
    @NotNull
    private Boolean estado;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_facultad")
    private FacultadEntity facultad;
}
