package com.upao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "citas")
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "fecha_cita_id")
    private Programacion_Cita fechaCita;

    @ManyToOne
    @JoinColumn(name = "hora_cita_id")
    private Horario_Cita horaCita;
    @Column(name = "recordatorio")
    private Boolean recordatorio;

    public Citas() {
    }

    public Citas(Long id, Paciente paciente, Medico medico, Programacion_Cita fechaCita, Horario_Cita horaCita, Boolean recordatorio) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.recordatorio = recordatorio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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

    public Boolean getRecordatorio() {
        return recordatorio;
    }

    public void setRecordatorio(Boolean recordatorio) {
        this.recordatorio = recordatorio;
    }
}
