package com.upao.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class RegistroSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(precision = 5, scale = 2)
    private BigDecimal peso;

    @Column(length = 15)
    private String presionArterial;

    @Column(precision = 5, scale = 2)
    private BigDecimal nivelGlucosa;

    public int getId() {
        return id;
    }

    public void setId(int ID_Registro) {
        this.id = ID_Registro;
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
