package com.lavanderia.ProgettoGestionale.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.cj.xdevapi.Client;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Capi")
public class Capi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCapo;
    private String nomeCapo;
    private String descrizione;

    @ManyToMany(mappedBy = "capi")
    @JsonIgnore // For error: Cannot call sendError() after the response has been committed
    private Set<Cliente> clienti = new HashSet<>();

    public Integer getIdCapo() {
        return idCapo;
    }

    public Capi setIdCapo(Integer idCapo) {
        this.idCapo = idCapo;
        return this;
    }

    public String getNomeCapo() {
        return nomeCapo;
    }

    public Capi setNomeCapo(String nomeCapo) {
        this.nomeCapo = nomeCapo;
        return this;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Capi setDescrizione(String descrizione) {
        this.descrizione = descrizione;
        return this;
    }

    public Set<Cliente> getClienti() {
        return clienti;
    }

    public Capi setClienti(Set<Cliente> clienti) {
        this.clienti = clienti;
        return this;
    }
}
