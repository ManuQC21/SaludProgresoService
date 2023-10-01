package com.upao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RecetaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Receta;

    @ManyToOne
    @JoinColumn(name = "ID_Paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "ID_Medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "ID_Medicamento")
    private Medicamentos medicamentos;

    @Column(name = "FechaReceta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaReceta;

    public int getID_Receta() {
        return ID_Receta;
    }

    public void setID_Receta(int ID_Receta) {
        this.ID_Receta = ID_Receta;
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

    public Medicamentos getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Medicamentos medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Date getFechaReceta() {
        return FechaReceta;
    }

    public void setFechaReceta(Date fechaReceta) {
        FechaReceta = fechaReceta;
    }


}
