package com.escalafon.proyecto_escalafon.app.models.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cargousuario")
@Getter
@Setter
public class Cargo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCargo;
    @NotEmpty
    private String tipoCargo;
    @NotEmpty
    private boolean estado;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<Usuario> usuario;

    public Cargo() {
        usuario= new ArrayList<Usuario>();
    }
    private static final long serialVersionUID = 1L;
}
