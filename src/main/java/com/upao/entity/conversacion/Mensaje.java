package com.upao.entity.conversacion;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensajes")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "conversacion_id", nullable = false)
    @JsonBackReference // Esta anotación manejará la referencia 'back' parte de la relación
    private Conversacion conversacion;

    @Column(nullable = false)
    private String contenido;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Formato para la fecha y hora
    private LocalDateTime fechaHora;

    @Column(nullable = false)
    private int remitenteId;  // ID del paciente o médico que envía el mensaje


    public Mensaje() {
    }

    public Mensaje(int id, Conversacion conversacion, String contenido, LocalDateTime fechaHora, int remitenteId) {
        this.id = id;
        this.conversacion = conversacion;
        this.contenido = contenido;
        this.fechaHora = fechaHora;
        this.remitenteId = remitenteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Conversacion getConversacion() {
        return conversacion;
    }

    public void setConversacion(Conversacion conversacion) {
        this.conversacion = conversacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getRemitenteId() {
        return remitenteId;
    }

    public void setRemitenteId(int remitenteId) {
        this.remitenteId = remitenteId;
    }
}
