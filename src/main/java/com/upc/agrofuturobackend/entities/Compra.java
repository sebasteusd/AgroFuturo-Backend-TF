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
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompra;

    @Column(name="cantidad", nullable = false, length = 30)
    private int cantidad;

    @Column(name="fechaCompra", nullable = false, length = 30)
    private LocalDate fechaCompra;

    @Column(name="total", nullable = false, length = 30)
    private double total;

    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "IdProducto")
    private Producto producto;
}
