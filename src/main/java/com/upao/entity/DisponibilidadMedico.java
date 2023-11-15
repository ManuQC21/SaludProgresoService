package com.upao.entity;
import javax.persistence.*;
@Entity
public class DisponibilidadMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "fecha_cita_id")
    private FechasCitas fechaCita;

    @ManyToOne
    @JoinColumn(name = "hora_cita_id")
    private HorasCitas horaCita;

    public DisponibilidadMedico() {
    }

    public DisponibilidadMedico(Long id, Medico medico, FechasCitas fechaCita, HorasCitas horaCita) {
        this.id = id;
        this.medico = medico;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public FechasCitas getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(FechasCitas fechaCita) {
        this.fechaCita = fechaCita;
    }

    public HorasCitas getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(HorasCitas horaCita) {
        this.horaCita = horaCita;
    }
}