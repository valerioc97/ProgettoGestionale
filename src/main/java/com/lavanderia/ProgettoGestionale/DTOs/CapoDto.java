package com.lavanderia.ProgettoGestionale.DTOs;

public class CapoDto {

    private String nomeCapo;
    private String descrizione;

    public String getNomeCapo() {
        return nomeCapo;
    }

    public CapoDto setNomeCapo(String nomeCapo) {
        this.nomeCapo = nomeCapo;
        return this;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public CapoDto setDescrizione(String descrizione) {
        this.descrizione = descrizione;
        return this;
    }
}
