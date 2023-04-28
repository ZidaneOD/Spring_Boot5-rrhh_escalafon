package com.escalafon.proyecto_escalafon.app.models.entitys;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class UsuarioEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario",length = 6)
    private Integer id;
    @NotEmpty
    @Max(50)
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
    @Column(length = 150)
    private String correo;
    @NotBlank
    @Column(length = 100)
    private String login;
    @NotEmpty
    private String pass;
    private boolean estado;
    @OneToOne
    @JoinColumn(name = "id_cargo")
    private CargoEntity cargoEntity;

    private static final long serialVersionUID = 1L;

}
