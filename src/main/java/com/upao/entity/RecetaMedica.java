package com.upao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RecetaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_Paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "ID_Medico")
    private Medico medico;
    @Column
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date FechaReceta;

    public int getId() {
        return id;
    }

    public void setId(int ID_Receta) {
        this.id = ID_Receta;
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

    public Date getFechaReceta() {
        return FechaReceta;
    }

    public void setFechaReceta(Date fechaReceta) {
        FechaReceta = fechaReceta;
    }


}
