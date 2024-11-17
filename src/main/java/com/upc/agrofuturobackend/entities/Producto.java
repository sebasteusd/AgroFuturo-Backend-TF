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
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idProducto;

    @Column(name = "NombreProducto", nullable = false, length = 30)
    private String nombreProducto;

    @Column(name="DescripcionProducto", nullable = false, length = 100)
    private String descripcionProducto;

    @Column(name = "PrecioProducto", nullable = false)
    private double precioProducto;

    @ManyToOne
    @JoinColumn(name = "IdAgricultor")
    private Agricultor agricultor;
}
