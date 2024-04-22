package com.lavanderia.ProgettoGestionale.Controller;

import com.lavanderia.ProgettoGestionale.Assembler.CostruzioneModelInput;
import com.lavanderia.ProgettoGestionale.DTOs.CapoDto;
import com.lavanderia.ProgettoGestionale.DTOs.ClienteDto;
import com.lavanderia.ProgettoGestionale.Models.Capi;
import com.lavanderia.ProgettoGestionale.Models.Cliente;
import com.lavanderia.ProgettoGestionale.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lavanderia")
@CrossOrigin
public class ClientiController {

    @Autowired
    private ClienteService clienteService;


    @CrossOrigin(origins = "*")
    @GetMapping("/clienti")
    public ResponseEntity<List<Cliente>> getClienti(){

        return ResponseEntity.ok(clienteService.getAllClienti());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/cliente")
    public ResponseEntity<List<Cliente>> getCliente(@RequestParam(required = false) Integer idCliente,
                                              @RequestParam(required = false) String nome,
                                              @RequestParam(required = false) String cognome){


        return ResponseEntity.ok(clienteService.ricercaEstesa(idCliente, nome, cognome));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/cliente")
    public ResponseEntity<String> inserisciCliente(@RequestBody ClienteDto clienteDto){

        CostruzioneModelInput cmi = new CostruzioneModelInput();

        Cliente cliente = cmi.dtoToModel(clienteDto);

        String res = clienteService.postCliente(cliente);

        return ResponseEntity.ok(res);

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(value = "/cliente/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> deleteCliente(@PathVariable Integer id){

        String res = clienteService.deleteCliente(id);

        return ResponseEntity.ok(res);

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/clienti")
    public ResponseEntity<String> deleteAllClienti(){

        String res = clienteService.deleteClienti();

        return ResponseEntity.ok(res);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/cliente/capo/{idCliente}/{idCapo}")
    public ResponseEntity<String> deleteCapo(@PathVariable Integer idCapo, @PathVariable Integer idCliente){
        String res = clienteService.deleteCapo(idCapo, idCliente);

        return ResponseEntity.ok(res);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/cliente/capo/{idCliente}")
    public ResponseEntity<String> inserimentoCapo(@RequestBody List<CapoDto> capoDto, @PathVariable Integer idCliente){

        List<Capi> capi = new CostruzioneModelInput().dtoToModel(capoDto);

        String res = clienteService.inserimentoCapo(capi, idCliente);

        return ResponseEntity.ok(res);

    }

    @CrossOrigin(origins = "*")
    @PutMapping("/cliente/{idCliente}")
    public ResponseEntity<String> updateCliente(@RequestBody ClienteDto clienteDto, @PathVariable Integer idCliente){

        System.out.println(clienteDto);
        System.out.println(idCliente);
        Cliente cliente = new CostruzioneModelInput().dtoToModel(clienteDto);
        String res = clienteService.updateCliente(cliente, idCliente);

        return ResponseEntity.ok(res);
    }



}
