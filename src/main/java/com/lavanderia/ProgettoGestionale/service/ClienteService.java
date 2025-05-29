package com.lavanderia.ProgettoGestionale.service;

import com.lavanderia.ProgettoGestionale.repository.ClienteRepository;
import com.lavanderia.ProgettoGestionale.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

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

    public String postCliente(Cliente cliente){
        String res;
        try{
            clienteRepository.save(cliente);
            res = "OK";
        }catch (Exception e){
            e.printStackTrace();
            res="KO";
        }

        return res;
    }

    public String deleteCliente(Integer id){
        String res;
        try{
            clienteRepository.deleteById(id);
            res="OK";
        }catch (Exception e){
            e.printStackTrace();
            res="KO";
        }
        return res;
    }

    public String deleteClienti(){
        String res;

        try{
            clienteRepository.deleteAll();
            res = "OK";
        }catch (Exception e){
            e.printStackTrace();
            res = "KO";
        }
        return res;
    }

    public String updateCliente(Cliente cliente, Integer idCliente){
        String res;
        try{
            clienteRepository.updateClienteByclienteEntityAndIdCliente(cliente.getNome(), cliente.getCognome(),
                    cliente.getIndirizzo(), cliente.getNumeroDiTelefono(), idCliente);
            res = "KO";
        }catch (Exception e){
            e.printStackTrace();
            res = "KO";
        }

        return res;
    }


}
