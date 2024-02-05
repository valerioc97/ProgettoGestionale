package com.lavanderia.ProgettoGestionale.dtos;

public class ClienteDto {

    private String nome;
    private String cognome;
    private String comuneDiNascita;

    private String nomeCapo;
    private String descrizione;

    public String getNomeCapo() {
        return nomeCapo;
    }

    public ClienteDto setNomeCapo(String nomeCapo) {
        this.nomeCapo = nomeCapo;
        return this;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public ClienteDto setDescrizione(String descrizione) {
        this.descrizione = descrizione;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public ClienteDto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCognome() {
        return cognome;
    }

    public ClienteDto setCognome(String cognome) {
        this.cognome = cognome;
        return this;
    }

    public String getComuneDiNascita() {
        return comuneDiNascita;
    }

    public ClienteDto setComuneDiNascita(String comuneDiNascita) {
        this.comuneDiNascita = comuneDiNascita;
        return this;
    }
}
