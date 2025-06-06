package com.lavanderia.ProgettoGestionale.service;

import com.lavanderia.ProgettoGestionale.model.dto.ClienteDto;
import com.lavanderia.ProgettoGestionale.model.mapper.ClienteMapper;
import com.lavanderia.ProgettoGestionale.repository.ClienteRepository;
import com.lavanderia.ProgettoGestionale.model.entity.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    public List<Cliente> getAllClienti(){
        return clienteRepository.findAll();
    }

    public List<Cliente> ricercaEstesa(Integer id, String nome, String cognome) {
        List<Cliente> clienti = new ArrayList<>();
        if(id != null){
            Optional<Cliente> op = clienteRepository.findById(id);
            clienti.add(op.orElseGet(Cliente::new));
        }else if(nome != null && cognome != null){
            clienti.add(clienteRepository.findByNomeAndCognome(nome, cognome));
        } else if (nome != null) {
            clienti = clienteRepository.findByNome(nome);
        }else if(cognome != null){
            clienti.add(clienteRepository.findByCognome(cognome));
        }
        return clienti;

    }

    public void postCliente(ClienteDto clienteDto){

        try{
            clienteRepository.save(clienteMapper.clienteDtoIntoClienteEntity(clienteDto));
        }catch (Exception e){
            logger.error("Errore durante il salvataggio del seguente cliente: {}, messaggio: {}", clienteDto, e.getMessage());
        }
    }

    public void deleteCliente(Integer id){
        try{
            clienteRepository.deleteById(id);
        }catch (Exception e){
            logger.error("Errore durante l'eliminazione del cliente numero: {}, messaggio: {}", id, e.getMessage());
        }
    }

    public void deleteClienti(){

        try{
            clienteRepository.deleteAll();
        }catch (Exception e){
            logger.error("Errore durante l'eliminazione di tutti i clienti. Messaggio: {}", e.getMessage());
        }
    }

    public void updateCliente(ClienteDto cliente, Integer idCliente){
        try{
            clienteRepository.updateClienteByclienteEntityAndIdCliente(cliente.getNome(), cliente.getCognome(),
                    cliente.getIndirizzo(), cliente.getNumeroDiTelefono(), idCliente);
        }catch (Exception e){
            logger.error("Errore durante l'aggiornamento del id cliente {} {}", idCliente, cliente);
        }
    }


}
