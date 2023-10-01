package com.upao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Medico;

    @Column(name = "NombreMedico", length = 255, nullable = false)
    private String NombreMedico;

    @Column(name = "Especialidad", length = 255, nullable = false)
    private String Especialidad;

    public int getID_Medico() {
        return ID_Medico;
    }
    @OneToMany(mappedBy = "medicoAsignado")
    private List<Paciente> pacientes;

    public void setID_Medico(int ID_Medico) {
        this.ID_Medico = ID_Medico;
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

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
