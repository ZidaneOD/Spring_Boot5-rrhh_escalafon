package com.escalafon.proyecto_escalafon.app.models.entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "categorias")
@Getter
@Setter
public class CategoriaEntity implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_categoria",nullable = false)
    private Integer idCategoria;
    @NotEmpty
    @Max(45)
    @Column(name = "tipo_categoria", length = 45)
    private String tipoCategoria;
    @NotNull
    private Boolean estado;
    private static final long serialVersionUID = 1L;
}
