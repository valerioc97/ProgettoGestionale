package com.lavanderia.ProgettoGestionale.model.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@Setter
@Getter
public class ClienteDto {

    private String nome;
    private String cognome;
    private String indirizzo;
    private String numeroDiTelefono;

}
