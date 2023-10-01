package com.upao.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class RegistroSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Registro;

    @ManyToOne
    @JoinColumn(name = "ID_Paciente")
    private Paciente paciente;

    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "Peso", precision = 5, scale = 2)
    private BigDecimal peso;

    @Column(name = "PresionArterial", length = 15)
    private String presionArterial;

    @Column(name = "NivelGlucosa", precision = 5, scale = 2)
    private BigDecimal nivelGlucosa;

    public int getID_Registro() {
        return ID_Registro;
    }

    public void setID_Registro(int ID_Registro) {
        this.ID_Registro = ID_Registro;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(String presionArterial) {
        this.presionArterial = presionArterial;
    }

    public BigDecimal getNivelGlucosa() {
        return nivelGlucosa;
    }

    public void setNivelGlucosa(BigDecimal nivelGlucosa) {
        this.nivelGlucosa = nivelGlucosa;
    }


}
