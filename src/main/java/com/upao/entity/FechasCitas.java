package com.upao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "fechas_citas")
public class FechasCitas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;    // Fecha de la cita

    @OneToMany(mappedBy = "fechaCita", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<HorasCitas> horasCitas;     // Lista de horas de citas asociadas a esta fecha

    public FechasCitas() {
    }

    public FechasCitas(LocalDate fecha, List<HorasCitas> horasCitas) {
        this.fecha = fecha;
        this.horasCitas = horasCitas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<HorasCitas> getHorasCitas() {
        return horasCitas;
    }

    public void setHorasCitas(List<HorasCitas> horasCitas) {
        this.horasCitas = horasCitas;
    }
}