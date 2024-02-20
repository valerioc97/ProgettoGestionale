package com.lavanderia.ProgettoGestionale.Controlles;

import com.lavanderia.ProgettoGestionale.Assembler.CostruzioneModelInput;
import com.lavanderia.ProgettoGestionale.dtos.CapoDto;
import com.lavanderia.ProgettoGestionale.dtos.ClienteDto;
import com.lavanderia.ProgettoGestionale.models.Capi;
import com.lavanderia.ProgettoGestionale.models.Cliente;
import com.lavanderia.ProgettoGestionale.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lavanderia")
@CrossOrigin
public class MainController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clienti")
    public ResponseEntity<List<Cliente>> getClienti(){

        return ResponseEntity.ok(clienteService.getAllClienti());
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<Cliente>> getCliente(@RequestParam(required = false) Integer idCliente,
                                              @RequestParam(required = false) String nome,
                                              @RequestParam(required = false) String cognome){


        return ResponseEntity.ok(clienteService.ricercaEstesa(idCliente, nome, cognome));
    }

    @PostMapping("/cliente")
    public ResponseEntity<String> inserisciCliente(@RequestBody ClienteDto clienteDto){

        CostruzioneModelInput cmi = new CostruzioneModelInput();

        Cliente cliente = cmi.dtoToModel(clienteDto);

        String res = clienteService.postCliente(cliente);

        return ResponseEntity.ok(res);

    }

    @DeleteMapping(value = "/cliente/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> deleteCliente(@PathVariable Integer id){

        String res = clienteService.deleteCliente(id);

        return ResponseEntity.ok(res);

    }

    @DeleteMapping("/clienti")
    public ResponseEntity<String> deleteAllClienti(){

        String res = clienteService.deleteClienti();

        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/cliente/capo/{idCliente}/{idCapo}")
    public ResponseEntity<String> deleteCapo(@PathVariable Integer idCapo, @PathVariable Integer idCliente){
        String res = clienteService.deleteCapo(idCapo, idCliente);

        return ResponseEntity.ok(res);
    }

    @PostMapping("/cliente/capo/{idCliente}")
    public ResponseEntity<String> inserimentoCapo(@RequestBody CapoDto capoDto, @PathVariable Integer idCliente){

        Capi capo = new CostruzioneModelInput().dtoToModel(capoDto);

        String res = clienteService.inserimentoCapo(capo, idCliente);

        return ResponseEntity.ok(res);

    }

    @PutMapping("/cliente/{idCliente}")
    public ResponseEntity<String> updateCliente(@RequestBody ClienteDto clienteDto, @PathVariable Integer idCliente){

        System.out.println(clienteDto);
        System.out.println(idCliente);
        Cliente cliente = new CostruzioneModelInput().dtoToModel(clienteDto);
        String res = clienteService.updateCliente(cliente, idCliente);

        return ResponseEntity.ok(res);
    }

}
