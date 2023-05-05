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
    @Column(name = "nombres",length = 50)
    private String nombre;
    @NotEmpty
    @Column(name = "apellido_pat",length = 100)
    private String apellidoPat;
    @NotEmpty
    @Column(name = "apellido_mat",length = 100)
    private String apellidoMat;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_naci")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date fechaNaci;
    @NotEmpty
    @Email
    @Column(name = "correo",length = 150)
    private String correo;
    @NotEmpty
    @Column(name = "login",length = 100)
    private String login;
    @NotEmpty
    @Column(name = "pass",length = 200)
    private String pass;
    private boolean estado;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "id_cargo",referencedColumnName = "id_cargo")
    private CargoEntity cargoEntity;

    private static final long serialVersionUID = 1L;

}
