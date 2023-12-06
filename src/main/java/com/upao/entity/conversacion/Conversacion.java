package com.upao.entity.conversacion;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.upao.entity.Medico;
import com.upao.entity.Paciente;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conversaciones")
public class Conversacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @OneToMany(mappedBy = "conversacion", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Esta anotación manejará la referencia 'forward' parte de la relación
    private List<Mensaje> mensajes;

    public Conversacion() {
    }

    public Conversacion(int id, Paciente paciente, Medico medico, List<Mensaje> mensajes) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.mensajes = mensajes;
    }

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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
}
