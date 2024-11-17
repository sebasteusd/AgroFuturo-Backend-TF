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
@Table(name = "Agricultor")
public class Agricultor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgricultor;

    @Column(name = "NombreAgricultor", nullable = false, length = 60)
    private String nombreAgricultor;

    @Column(name = "CorreoAgricultor", nullable = false, length = 100)
    private String correoAgricultor;

    @Column(name = "TelefonoAgricultor", nullable = false, length = 30)
    private String telefonoAgricultor;

    @Column(name = "UbicacionAgricultor", nullable = false, length = 100)
    private String ubicacionAgricultor;

    @Column(name = "TipoProductoAgricultor", nullable = false, length = 30)
    private String tipoProductoAgricultor;

    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private Users user;
}
