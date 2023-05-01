package com.escalafon.proyecto_escalafon.app.models.entitys;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class UsuarioEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    @Column(name = "apellido_pat")
    private String apellidoPat;
    @NotEmpty
    @Column(name = "apellido_mat")
    private String apellidoMat;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_naci")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date fechaNaci;
    @NotEmpty
    @Email
    private String correo;
    @NotEmpty
    private String login;
    @NotEmpty
    private String pass;
    private boolean estado;
    private boolean pruebaramas;
    @OneToOne
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
    private CargoEntity cargoEntity;

    private static final long serialVersionUID = 1L;

}
