package com.lavanderia.ProgettoGestionale.model.mapper;

import com.lavanderia.ProgettoGestionale.model.dto.ClienteDto;
import com.lavanderia.ProgettoGestionale.model.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente clienteDtoIntoClienteEntity(ClienteDto clienteDto);
}
