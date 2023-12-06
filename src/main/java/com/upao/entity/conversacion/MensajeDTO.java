package com.upao.entity.conversacion;

public class MensajeDTO {
    private int conversacionId;
    private int remitenteId;
    private String contenido;

    public MensajeDTO() {
    }

    public MensajeDTO(int conversacionId, int remitenteId, String contenido) {
        this.conversacionId = conversacionId;
        this.remitenteId = remitenteId;
        this.contenido = contenido;
    }

    public int getConversacionId() {
        return conversacionId;
    }

    public void setConversacionId(int conversacionId) {
        this.conversacionId = conversacionId;
    }

    public int getRemitenteId() {
        return remitenteId;
    }

    public void setRemitenteId(int remitenteId) {
        this.remitenteId = remitenteId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
