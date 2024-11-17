package com.upc.agrofuturobackend.dtos;

import jakarta.persistence.Column;
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
public class UsersDTO {
    private int idUsuario;
    private String username;
    private String password;
    private Boolean enabled;
    private String nombreUsuario;
    private String correoUsuario;
    private String telefonoUsuario;
    private String tipoUsuario;
    private LocalDate fechaCreacion;
}
