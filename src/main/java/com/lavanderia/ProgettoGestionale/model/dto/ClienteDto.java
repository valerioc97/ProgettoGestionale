package com.lavanderia.ProgettoGestionale.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClienteDto {

    private String nome;
    private String cognome;
    private String indirizzo;
    private String numeroDiTelefono;

}
