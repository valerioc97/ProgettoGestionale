package com.lavanderia.ProgettoGestionale.controller;

import com.lavanderia.ProgettoGestionale.model.dto.ClienteDto;
import com.lavanderia.ProgettoGestionale.model.dto.GenericFilter;
import com.lavanderia.ProgettoGestionale.model.entity.Cliente;
import com.lavanderia.ProgettoGestionale.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lavanderia")
@CrossOrigin(origins = "*")
public class ClientiController {

    @Autowired
    private ClienteService clienteService;


    @GetMapping("anagrafica/clienti")
    public ResponseEntity<List<Cliente>> getClienti() {
        return ResponseEntity.ok(clienteService.getAllClienti());
    }


    @GetMapping("anagrafica/cliente")
    public ResponseEntity<List<Cliente>> getCliente(@ModelAttribute GenericFilter request) {
        return ResponseEntity.ok(clienteService.ricercaEstesa(request.getIdCliente(),
                request.getNome(),
                request.getCognome()));
    }

    @PostMapping(value = "anagrafica/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public void inserisciCliente(@RequestBody ClienteDto clienteDto) {
        clienteService.postCliente(clienteDto);

    }

    @DeleteMapping(value = "anagrafica/cliente/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public void deleteCliente(@ModelAttribute GenericFilter request) {
        clienteService.deleteCliente(request.getIdCliente());

    }

    @DeleteMapping("anagrafica/clienti")
    public void deleteAllClienti() {
        clienteService.deleteClienti();
    }

    @PutMapping("anagrafica/cliente/{idCliente}")
    public void updateCliente(@RequestBody ClienteDto clienteDto, @ModelAttribute GenericFilter request) {
        clienteService.updateCliente(clienteDto, request.getIdCliente());
    }

}
