package com.upc.agrofuturobackend.entities;

import jakarta.persistence.*;
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
@Entity
@Table(name = "GrupoEmpresaAgricultor")
public class GrupoEmpresaAgricultor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGrupoEmpresaAgricultor;

    @Column(name = "FechaUnion", nullable = false)
    private LocalDate fechaUnion;

    @Column(name = "EstadoMiembro", nullable = false, length = 30)
    private String estadoMiembro;

    @Column(name = "RolMiembro", nullable = false, length = 30)
    private String rolMiembro;

    @Column(name = "Observaciones", nullable = false, length = 30)
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "IdAgricultor")
    private Agricultor agricultor;
}
