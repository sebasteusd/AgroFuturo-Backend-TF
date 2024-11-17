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
@Table(name = "GrupoAgricultor")
public class GrupoAgricultor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idGrupo;

    @Column(name = "NombreGrupo", nullable = false, length = 30)
    private String nombreGrupo;

    @Column(name="DescripcionGrupo", nullable = false, length = 100)
    private String descripcionGrupo;

    @Column(name = "FechaCreacion", nullable = false, length = 30)
    private LocalDate fechaCreacion;

    @Column(name = "EstadoGrupo", nullable = false, length = 30)
    private String estadoGrupo;

    @Column(name = "MaxMiembros", nullable = false)
    private int maxMiembros;

    @ManyToOne
    @JoinColumn(name = "IdAgricultor")
    private Agricultor agricultor;
}
