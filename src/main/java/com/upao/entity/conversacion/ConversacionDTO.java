package com.upao.entity.conversacion;

public class ConversacionDTO {
    private int pacienteId;
    private int medicoId;

    public ConversacionDTO() {
    }

    public ConversacionDTO(int pacienteId, int medicoId) {
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public int getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }
}
