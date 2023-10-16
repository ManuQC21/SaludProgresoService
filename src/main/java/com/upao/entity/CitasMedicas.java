package com.upao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CitasMedicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_Paciente")
    private Paciente paciente;

    @Column(name = "FechaHoraCita")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaHoraCita;

    @Column(name = "AreaEspecialidad", length = 255)
    private String AreaEspecialidad;

    @Column(name = "Comentarios", length = 1000)
    private String Comentarios;
    @OneToOne
    @JoinColumn(name = "ID_Medico")
    private Medico medico;

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
        return FechaHoraCita;
    }

    public void setFechaHoraCita(Date fechaHoraCita) {
        FechaHoraCita = fechaHoraCita;
    }

    public String getAreaEspecialidad() {
        return AreaEspecialidad;
    }

    public void setAreaEspecialidad(String areaEspecialidad) {
        AreaEspecialidad = areaEspecialidad;
    }

    public String getComentarios() {
        return Comentarios;
    }

    public void setComentarios(String comentarios) {
        Comentarios = comentarios;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
