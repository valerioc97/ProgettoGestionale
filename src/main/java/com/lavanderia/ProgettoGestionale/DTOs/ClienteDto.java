package com.lavanderia.ProgettoGestionale.DTOs;

public class ClienteDto {

    private String nome;
    private String cognome;
    private String indirizzo;

    private String numeroDiTelefono;

    public String getIndirizzo() {
        return indirizzo;
    }

    public ClienteDto setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
        return this;
    }

    public String getNumeroDiTelefono() {
        return numeroDiTelefono;
    }

    public ClienteDto setNumeroDiTelefono(String numeroDiTelefono) {
        this.numeroDiTelefono = numeroDiTelefono;
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
}
