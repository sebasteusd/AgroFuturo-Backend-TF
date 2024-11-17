package com.upc.agrofuturobackend.dtos;

import com.upc.agrofuturobackend.entities.Producto;
import com.upc.agrofuturobackend.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {
    private int idCompra;
    private int cantidad;
    private LocalDate fechaCompra;
    private double total;
    private Users user;
    private Producto producto;
}
