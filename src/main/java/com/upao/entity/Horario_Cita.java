package com.upao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "horas_citas")
public class Horario_Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hora")
    @Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$", message = "Formato de hora inválido.")
    private String hora;  // Ejemplo: "08:00", "09:00", etc.

    @Column(name = "disponible")
    private Boolean disponible;

    @ManyToOne
    @JoinColumn(name = "fecha_cita_id")
    @JsonIgnore
    private Programacion_Cita fechaCita;


    public Horario_Cita(Long id, String hora, Boolean disponible, Programacion_Cita fechaCita) {
        this.id = id;
        this.hora = hora;
        this.disponible = disponible;
        this.fechaCita = fechaCita;
    }

    public Horario_Cita() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Programacion_Cita getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Programacion_Cita fechaCita) {
        this.fechaCita = fechaCita;
    }
}
