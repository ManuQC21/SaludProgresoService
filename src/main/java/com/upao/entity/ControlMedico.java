package com.upao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ControlMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_Paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "ID_Medico")
    private Medico medico;

    @Column(name = "FechaControl")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaControl;

    @Column(name = "Resultados", length = 1000)
    private String Resultados;

    @Lob
    @Column(name = "Documentos")
    private byte[] Documentos;

    public int getId() {
        return id;
    }

    public void setId(int ID_Control) {
        this.id = ID_Control;
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

    public Date getFechaControl() {
        return FechaControl;
    }

    public void setFechaControl(Date fechaControl) {
        FechaControl = fechaControl;
    }

    public String getResultados() {
        return Resultados;
    }

    public void setResultados(String resultados) {
        Resultados = resultados;
    }

    public byte[] getDocumentos() {
        return Documentos;
    }

    public void setDocumentos(byte[] documentos) {
        Documentos = documentos;
    }

}
