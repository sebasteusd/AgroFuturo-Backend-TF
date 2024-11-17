package com.upc.agrofuturobackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(unique = true, length = 30)
    private String username;
    @Column(length = 200)
    private String password;

    private Boolean enabled;

    @Column(name = "NombreUsuario", nullable = false, length = 30)
    private String nombreUsuario;

    @Column(name = "CorreoUsuario", nullable = false, length = 30)
    private String correoUsuario;

    @Column(name = "TelefonoUsuario", nullable = false, length = 30)
    private String telefonoUsuario;

    @Column(name = "TipoUsuario", nullable = false, length = 30)
    private String tipoUsuario;

    @Column(name="FechaCreacion", nullable = false)
    private LocalDate fechaCreacion;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Role> roles;
}
