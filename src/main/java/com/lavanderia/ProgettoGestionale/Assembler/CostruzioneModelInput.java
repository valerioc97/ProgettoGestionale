package com.lavanderia.ProgettoGestionale.Assembler;

import com.lavanderia.ProgettoGestionale.dtos.CapoDto;
import com.lavanderia.ProgettoGestionale.dtos.ClienteDto;
import com.lavanderia.ProgettoGestionale.models.Capi;
import com.lavanderia.ProgettoGestionale.models.Cliente;

import java.util.HashSet;
import java.util.Set;

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
