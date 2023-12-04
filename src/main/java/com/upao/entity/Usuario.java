package com.upao.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 500)
    @NotBlank(message = "El email es obligatorio.")
    @Email(message = "Debe ser un email válido.")
    @Size(max = 500, message = "El email no puede exceder los 500 caracteres.")
    private String email;

    @Column(length = 20)
    @NotBlank(message = "La clave es obligatoria.")
    @Size(min = 8, max = 20, message = "La clave debe tener entre 8 y 20 caracteres.")
    private String clave;

    @Column
    private boolean vigencia;

    @OneToOne
    @NotNull(message = "El paciente asociado es obligatorio.")
    private Paciente paciente;

    @OneToOne
    @NotNull(message = "El médico asociado es obligatorio.")
    private Medico medico;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El rol es obligatorio.")
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