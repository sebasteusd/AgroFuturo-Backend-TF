package com.upc.agrofuturobackend.dtos;

import com.upc.agrofuturobackend.entities.Agricultor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrupoAgricultorDTO {
    private int idGrupo;
    private String nombreGrupo;
    private String descripcionGrupo;
    private LocalDate fechaCreacion;
    private String estadoGrupo;
    private int maxMiembros;
    private Agricultor agricultor;
}
