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
@Table(name = "Notificacion")
public class Notificacion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idNotificacion;

    @Column(name="Titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name="Mensaje", nullable = false, length = 100)
    private String mensaje;

    @Column(name="TipoNotificacion", nullable = false, length = 30)
    private String tipoNotificacion;

    @Column(name = "Estado", nullable = false, length = 30)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idUsuarioRemitente")
    private Users usuarioRemitente;

    @ManyToOne
    @JoinColumn(name = "idUsuarioDestinatario")
    private Users usuarioDestinatario;
}
