package com.lavanderia.ProgettoGestionale.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CLIENTE")
    private int idCliente;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "COGNOME")
    private String cognome;

    @Column(name = "INDIRIZZO")
    private String indirizzo;

    @Column(name = "NUMERO_DI_TELEFONO")
    private String numeroDiTelefono;

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCognome() {
        return cognome;
    }

    public Cliente setCognome(String cognome) {
        this.cognome = cognome;
        return this;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public Cliente setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public Cliente setIdCliente(int idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public Cliente setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
        return this;
    }

    public String getNumeroDiTelefono() {
        return numeroDiTelefono;
    }

    public Cliente setNumeroDiTelefono(String numeroDiTelefono) {
        this.numeroDiTelefono = numeroDiTelefono;
        return this;
    }
}
