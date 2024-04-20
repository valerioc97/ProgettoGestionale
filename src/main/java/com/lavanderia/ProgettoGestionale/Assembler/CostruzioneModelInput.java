package com.lavanderia.ProgettoGestionale.Assembler;

import com.lavanderia.ProgettoGestionale.DTOs.CapoDto;
import com.lavanderia.ProgettoGestionale.DTOs.ClienteDto;
import com.lavanderia.ProgettoGestionale.Models.Capi;
import com.lavanderia.ProgettoGestionale.Models.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class CostruzioneModelInput {

    public List<Capi> dtoToModel(List<CapoDto> dto){

        return dto.stream().map(capoFromFe -> new Capi().setNomeCapo(capoFromFe.getNomeCapo()).setDescrizione(capoFromFe.getDescrizione())).collect(Collectors.toList());
    }

    public Cliente dtoToModel(ClienteDto dto){

        return new Cliente()
                .setNome(dto.getNome())
                .setCognome(dto.getCognome())
                .setIndirizzo(dto.getIndirizzo())
                .setNumeroDiTelefono(dto.getNumeroDiTelefono());
    }
}
