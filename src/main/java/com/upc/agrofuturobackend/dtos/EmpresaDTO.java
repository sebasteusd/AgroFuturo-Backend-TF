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
public class EmpresaDTO {
    private int idEmpresa;
    private String nombreEmpresa;
    private String correoEmpresa;
    private String telefonoEmpresa;
    private String ubicacionEmpresa;
    private String tipoIndustria;
    private Users user;
}
