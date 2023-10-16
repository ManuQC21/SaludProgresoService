package com.upao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Medicamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "ID_Paciente")
    private Paciente paciente;
    @Column(name = "NombreMedicamento", length = 255, nullable = false)
    private String NombreMedicamento;
    @Column(name = "FechaInicio")
    @Temporal(TemporalType.DATE)
    private Date FechaInicio;
    @Column(name = "FechaFinalizacion")
    @Temporal(TemporalType.DATE)
    private Date FechaFinalizacion;
    @Column(name = "IndicacionesMedicas", length = 1000)
    private String IndicacionesMedicas;
    @Column(name = "RecordatorioMedicacion")
    private boolean RecordatorioMedicacion;

    public int getId() {
        return id;
    }

    public void setId(int ID_Medicamento) {
        this.id = ID_Medicamento;
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
