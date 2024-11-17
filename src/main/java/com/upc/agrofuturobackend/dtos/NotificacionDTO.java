package com.upc.agrofuturobackend.dtos;

import com.upc.agrofuturobackend.entities.Users;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificacionDTO {
    private int idNotificacion;
    private String titulo;
    private String mensaje;
    private String tipoNotificacion;
    private String estado;
    private Users usuarioRemitente;
    private Users usuarioDestinatario;
}
