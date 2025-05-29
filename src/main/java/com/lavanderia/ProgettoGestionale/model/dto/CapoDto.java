package com.lavanderia.ProgettoGestionale.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CapoDto {

    private String nomeCapo;
    private String descrizione;

}
