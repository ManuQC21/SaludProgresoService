package com.upao.entity;

import javax.persistence.*;

@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NombreMedico", length = 500, nullable = false)
    private String NombreMedico;

    @Column(name = "Especialidad", length = 255, nullable = false)
    private String Especialidad;

    public int getId() {
        return id;
    }

    public void setId(int ID_Medico) {
        this.id = ID_Medico;
    }

    public String getNombreMedico() {
        return NombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        NombreMedico = nombreMedico;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }
}
