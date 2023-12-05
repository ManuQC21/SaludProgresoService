package com.upao.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 500)
    @Email(message = "Debe ser un email válido.")
    @Size(max = 500, message = "El email no puede exceder los 500 caracteres.")
    private String email;
    @Column(length = 20)
    @Size(min = 1, max = 20, message = "La clave debe tener entre 8 y 20 caracteres.")
    private String clave;
    @Column
    private boolean vigencia;
    @OneToOne
    private Paciente paciente;
    @OneToOne
    private Medico medico;

    @Enumerated(EnumType.STRING)
    private RolUsuario rol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isVigencia() {
        return vigencia;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}