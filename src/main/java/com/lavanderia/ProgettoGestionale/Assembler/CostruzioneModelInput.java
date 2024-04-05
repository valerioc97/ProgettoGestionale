package com.lavanderia.ProgettoGestionale.Assembler;

import com.lavanderia.ProgettoGestionale.DTOs.CapoDto;
import com.lavanderia.ProgettoGestionale.DTOs.ClienteDto;
import com.lavanderia.ProgettoGestionale.Models.Capi;
import com.lavanderia.ProgettoGestionale.Models.Cliente;

public class CostruzioneModelInput {

    public Capi dtoToModel(CapoDto dto){

        return new Capi().setNomeCapo(dto.getNomeCapo()).setDescrizione(dto.getDescrizione());
    }

    public Cliente dtoToModel(ClienteDto dto){

        return new Cliente()
                .setNome(dto.getNome())
                .setCognome(dto.getCognome())
                .setIndirizzo(dto.getIndirizzo())
                .setNumeroDiTelefono(dto.getNumeroDiTelefono());
    }
}
