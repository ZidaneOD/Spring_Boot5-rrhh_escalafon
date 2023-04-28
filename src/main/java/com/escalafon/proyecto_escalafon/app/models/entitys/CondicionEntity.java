package com.escalafon.proyecto_escalafon.app.models.entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "condiciones")
@Getter @Setter
public class CondicionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_condicion", nullable = false)
    private Integer idCondicion;
    @NotEmpty
    @Max(50)
    @Column(name = "tipo_condicion", length = 50)
    private String tipoCondicion;
    @NotNull
    private Boolean estado;
    private static final long serialVersionUID = 1L;
}
