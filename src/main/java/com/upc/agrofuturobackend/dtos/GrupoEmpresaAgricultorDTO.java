package com.upc.agrofuturobackend.dtos;

import com.upc.agrofuturobackend.entities.Agricultor;
import com.upc.agrofuturobackend.entities.Empresa;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrupoEmpresaAgricultorDTO {
    private int idGrupoEmpresaAgricultor;
    private LocalDate fechaUnion;
    private String estadoMiembro;
    private String rolMiembro;
    private String observaciones;
    private Empresa empresa;
    private Agricultor agricultor;
}
