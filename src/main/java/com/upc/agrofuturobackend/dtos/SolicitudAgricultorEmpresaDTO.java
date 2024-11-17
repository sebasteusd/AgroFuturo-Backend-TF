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
public class SolicitudAgricultorEmpresaDTO{
    private int idSolicitudAgricultorEmpresa;
    private LocalDate fechaSolicitud;
    private String estadoSolicitud;
    private LocalDate fechaRespuesta;
    private String comentario;
    private Empresa empresa;
    private Agricultor agricultor;
}
