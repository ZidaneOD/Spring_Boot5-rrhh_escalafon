package com.escalafon.proyecto_escalafon.app.models.entitys;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "cargousuarios")
@Getter
@Setter

public class CargoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo", nullable = false)
    private Integer id;
    @NotEmpty
    @Column(name = "tipo_cargo")
    private String tipoCargo;
<<<<<<< Updated upstream
    private boolean estado;
=======
    private Boolean estado;
>>>>>>> Stashed changes

    private static final long serialVersionUID = 1L;
}
