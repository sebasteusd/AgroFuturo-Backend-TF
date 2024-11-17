package com.upc.agrofuturobackend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SolicitudAgricultorEmpresa")
public class SolicitudAgricultorEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSolicitudAgricultorEmpresa;

    @Column(name = "FechaSolicitud", nullable = false)
    private LocalDate fechaSolicitud;

    @Column(name = "EstadoSolicitud", nullable = false, length = 30)
    private String estadoSolicitud;

    @Column(name = "FechaRespuesta", nullable = false, length = 30)
    private LocalDate fechaRespuesta;

    @Column(name = "Comentario", nullable = false, length = 30)
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "IdAgricultor")
    private Agricultor agricultor;
}
