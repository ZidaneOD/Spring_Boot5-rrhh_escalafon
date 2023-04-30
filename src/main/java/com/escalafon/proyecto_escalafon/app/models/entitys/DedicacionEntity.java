package com.escalafon.proyecto_escalafon.app.models.entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
@Table(name = "dedicaciones")
@Setter @Getter
public class DedicacionEntity implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_dedicacion", nullable = false)
    private Integer idDedicacion;
    @NotEmpty
    @Max(50)
    @Column(name = "tiempo_dedicacion", length = 50)
    private String tiempoDedicacion;
    @NotNull
    private Boolean estado;
}
