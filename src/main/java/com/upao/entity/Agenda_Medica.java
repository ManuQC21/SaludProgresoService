package com.upao.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Agenda_Medica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    @NotNull(message = "El médico es obligatorio.")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "fecha_cita_id")
    @NotNull(message = "La fecha de la cita es obligatoria.")
    private Programacion_Cita fechaCita;

    @ManyToOne
    @JoinColumn(name = "hora_cita_id")
    @NotNull(message = "La hora de la cita es obligatoria.")
    private Horario_Cita horaCita;

    public Agenda_Medica() {
    }

    public Agenda_Medica(Long id, Medico medico, Programacion_Cita fechaCita, Horario_Cita horaCita) {
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

    public Programacion_Cita getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Programacion_Cita fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Horario_Cita getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(Horario_Cita horaCita) {
        this.horaCita = horaCita;
    }
}