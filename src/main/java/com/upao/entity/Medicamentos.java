package com.upao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Medicamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @Column(length = 255, nullable = false)
    private String NombreMedicamento;

    @Temporal(TemporalType.DATE)
    private Date FechaInicio;
    @Temporal(TemporalType.DATE)
    private Date FechaFinalizacion;
    @Column( length = 1000)
    private String IndicacionesMedicas;

    private boolean RecordatorioMedicacion;


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

    public String getNombreMedicamento() {
        return NombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        NombreMedicamento = nombreMedicamento;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return FechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        FechaFinalizacion = fechaFinalizacion;
    }

    public String getIndicacionesMedicas() {
        return IndicacionesMedicas;
    }

    public void setIndicacionesMedicas(String indicacionesMedicas) {
        IndicacionesMedicas = indicacionesMedicas;
    }

    public boolean isRecordatorioMedicacion() {
        return RecordatorioMedicacion;
    }

    public void setRecordatorioMedicacion(boolean recordatorioMedicacion) {
        RecordatorioMedicacion = recordatorioMedicacion;
    }
}
