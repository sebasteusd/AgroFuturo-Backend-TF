package com.upc.agrofuturobackend.dtos;

import com.upc.agrofuturobackend.entities.Users;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgricultorDTO {
    private int idAgricultor;
    private String nombreAgricultor;
    private String correoAgricultor;
    private String telefonoAgricultor;
    private String ubicacionAgricultor;
    private String tipoProductoAgricultor;
    private Users user;
}
