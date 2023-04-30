package com.escalafon.proyecto_escalafon.app.models.entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
@Table(name = "hijos")
@Setter @Getter
public class HijoEntity implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_hijo",nullable = false)
    private Integer idHijo;
    @NotNull
    @Column(name = "numero_hijo")
    private Integer numeroHijo;
    @NotNull
    private Boolean estado;
    private static final long serialVersionUID=1L;
}
