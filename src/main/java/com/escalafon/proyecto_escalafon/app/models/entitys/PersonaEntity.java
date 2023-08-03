package com.escalafon.proyecto_escalafon.app.models.entitys;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.io.Serializable;
@Entity
@Table(name = "personas")
@Getter @Setter
public class PersonaEntity implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;
    @NotEmpty
    @Column(name = "nombres",length = 50)
    private String nombre;
    @NotEmpty
    @Column(name = "apellido_pat",length = 100)
    private String apellidoPat;
    @NotEmpty
    @Column(name = "apellido_mat",length = 100)
    private String apellidoMat;
    @NotEmpty
    @Column(name = "dni",length = 8)
    private String dni;
    @NotEmpty
    @Column(name = "profesion",length = 100)
    private String profesion;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_ingre")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date fechaIngre;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_naci")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date fechaNaci;
    @NotEmpty
    @Column(name = "domicilio",length = 150)
    private String domicilio;
    @NotEmpty
    @Email
    @Column(name = "correo",length = 150)
    private String correo;
    @NotEmpty
    @Column(name = "celular",length = 9)
    private String celular;
    @NotEmpty
    @Column(name = "hijos")
    private Integer hijos;
    @NotEmpty
    @Column(name = "estado_civil")
    private Integer estadoCivil;
    private boolean estado;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "id_condicion",referencedColumnName = "id_condicion")
    private CondicionEntity condicion;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "id_cargo",referencedColumnName = "id_cargo")
    private CargoEntity cargo;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "id_estadopersona",referencedColumnName = "id_estadopersona")
    private EstadoPersonaEntity estadoPersona;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "id_distrito",referencedColumnName = "id_distrito")
    private DistritoEntity distrito;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "id_categoria",referencedColumnName = "id_categoria")
    private CategoriaEntity categoria;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "id_dedicacion",referencedColumnName = "id_dedicacion")
    private DedicacionEntity dedicacion;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "id_escuela",referencedColumnName = "id_escuela")
    private EscuelaEntity escuela;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "id_regimen",referencedColumnName = "id_regimen")
    private RegimenPensionEntity regimenPension;

    private static final long serialVersionUID = 1L;
}
