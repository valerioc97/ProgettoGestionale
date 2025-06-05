package com.lavanderia.ProgettoGestionale.controller;

import com.lavanderia.ProgettoGestionale.model.dto.ClienteDto;
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
    public ResponseEntity<List<Cliente>> getCliente(@RequestParam(required = false) Integer idCliente,
                                                    @RequestParam(required = false) String nome,
                                                    @RequestParam(required = false) String cognome) {


        return ResponseEntity.ok(clienteService.ricercaEstesa(idCliente, nome, cognome));
    }

    @PostMapping(value = "anagrafica/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public void inserisciCliente(@RequestBody ClienteDto clienteDto) {
        clienteService.postCliente(clienteDto);

    }

    @DeleteMapping(value = "anagrafica/cliente/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public void deleteCliente(@PathVariable Integer id) {

        clienteService.deleteCliente(id);

    }

    @DeleteMapping("anagrafica/clienti")
    public ResponseEntity<String> deleteAllClienti() {

        return ResponseEntity.ok(clienteService.deleteClienti());
    }

    @PutMapping("anagrafica/cliente/{idCliente}")
    public void updateCliente(@RequestBody ClienteDto clienteDto, @PathVariable Integer idCliente) {

        clienteService.updateCliente(clienteDto, idCliente);
    }

}
