package com.escalafon.proyecto_escalafon.app.models.entity;

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
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUsuario;
    @NotEmpty
    private String apellidoPat;
    @NotEmpty
    private String apellidoMat;
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date fechaNaci;
    @NotEmpty
    @Email
    private String correo;
    @NotEmpty
    private String login;
    @NotEmpty
    private String pass;
    @NotNull
    private boolean estado;
    @OneToOne(mappedBy = "idCargo")
    private Cargo cargo;
    private static final long serialVersionUID = 1L;

}
