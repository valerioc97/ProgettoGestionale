package com.lavanderia.ProgettoGestionale.assembler;

import com.lavanderia.ProgettoGestionale.model.dto.ClienteDto;
import com.lavanderia.ProgettoGestionale.model.Cliente;

public class CostruzioneModelInput {

    public Cliente dtoToModel(ClienteDto dto){

        return new Cliente()
                .setNome(dto.getNome())
                .setCognome(dto.getCognome())
                .setIndirizzo(dto.getIndirizzo())
                .setNumeroDiTelefono(dto.getNumeroDiTelefono());
    }
}
