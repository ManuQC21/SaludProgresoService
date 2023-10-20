package com.upao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CitasMedicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCita;

    @Column(length = 255)
    private String areaEspecialidad;

    @Column(length = 1000)
    private String comentarios;
    @OneToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    private boolean recordatorioCita;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFechaHoraCita() {
        return fechaHoraCita;
    }

    public void setFechaHoraCita(Date fechaHoraCita) {
        this.fechaHoraCita = fechaHoraCita;
    }

    public String getAreaEspecialidad() {
        return areaEspecialidad;
    }

    public void setAreaEspecialidad(String areaEspecialidad) {
        this.areaEspecialidad = areaEspecialidad;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public boolean isRecordatorioCita() {
        return recordatorioCita;
    }

    public void setRecordatorioCita(boolean recordatorioCita) {
        this.recordatorioCita = recordatorioCita;
    }


}
