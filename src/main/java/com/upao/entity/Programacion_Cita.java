package com.upao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "fechas_citas")
@JsonIgnoreProperties({"horasCitas"}) // Ignora la propiedad horasCitas al serializar
public class Programacion_Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha", length = 100)
    private String fecha; // Fecha de la cita
    @OneToMany(mappedBy = "fechaCita", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Horario_Cita> horasCitas;

    public Programacion_Cita(Long id, String fecha, List<Horario_Cita> horasCitas) {
        this.id = id;
        this.fecha = fecha;
        this.horasCitas = horasCitas;
    }

    public Programacion_Cita() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Horario_Cita> getHorasCitas() {
        return horasCitas;
    }

    public void setHorasCitas(List<Horario_Cita> horasCitas) {
        this.horasCitas = horasCitas;
    }
}
