package com.lavanderia.ProgettoGestionale.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenericFilter {

    private Integer idCliente;
    private String nome;
    private String cognome;

}
