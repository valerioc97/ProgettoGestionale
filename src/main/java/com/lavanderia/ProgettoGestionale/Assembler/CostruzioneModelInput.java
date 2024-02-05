package com.lavanderia.ProgettoGestionale.Assembler;

import com.lavanderia.ProgettoGestionale.dtos.ClienteDto;
import com.lavanderia.ProgettoGestionale.models.Capi;
import com.lavanderia.ProgettoGestionale.models.Cliente;

import java.util.HashSet;
import java.util.Set;

public class CostruzioneModelInput {

    public Cliente dtoToModel(ClienteDto dto){
        Capi capo = new Capi()
                .setNomeCapo(dto.getNomeCapo())
                .setDescrizione(dto.getDescrizione());
        Set<Capi> capi = new HashSet<>();
        capi.add(capo);

        return new Cliente()
                .setNome(dto.getNome())
                .setCognome(dto.getCognome())
                .setComuneDiNascita(dto.getComuneDiNascita())
                .setCapi(capi);
    }
}
