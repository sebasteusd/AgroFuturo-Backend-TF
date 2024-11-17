package com.upc.agrofuturobackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpresa;

    @Column(name = "nombreEmpresa", nullable = false, length = 30)
    private String nombreEmpresa;

    @Column(name = "correoEmpresa", nullable = false, length = 100)
    private String correoEmpresa;

    @Column(name="telefonoEmpresa", nullable = false, length = 30)
    private String telefonoEmpresa;

    @Column(name="ubicacionEmpresa", nullable = false, length = 100)
    private String ubicacionEmpresa;

    @Column(name = "tipoIndustria", nullable = false, length = 30)
    private String tipoIndustria;

    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private Users user;
}
