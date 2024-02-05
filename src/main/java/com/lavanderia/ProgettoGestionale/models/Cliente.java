package com.lavanderia.ProgettoGestionale.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cliente_capo",
            joinColumns = @JoinColumn(name = "idCliente"),
            inverseJoinColumns = @JoinColumn(name = "idCapo"))
    private Set<Capi> capi = new HashSet<>();


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

    public Set<Capi> getCapi() {
        return capi;
    }

    public Cliente setCapi(Set<Capi> capi) {
        this.capi = capi;
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
