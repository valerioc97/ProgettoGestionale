package com.lavanderia.ProgettoGestionale.services;

import com.lavanderia.ProgettoGestionale.interfaces.ClienteRepository;
import com.lavanderia.ProgettoGestionale.models.Capi;
import com.lavanderia.ProgettoGestionale.models.Cliente;
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

    public String deleteCapo(Integer idCapo, Integer IdCliente) {
        String res;
        try{
            Optional<Cliente> oc = clienteRepository.findById(IdCliente);
            if(oc.isPresent()){
                Cliente cliente = oc.get();
                cliente.getCapi().removeIf(capo -> capo.getIdCapo().equals(idCapo));
                clienteRepository.save(cliente);
            }

            res = "OK";
        }catch (Exception e){
            e.printStackTrace();
            res = "KO";
        }
        return res;
    }

    public String inserimentoCapo(Capi capo, Integer idCliente) {
        String res;
        try{
            Optional<Cliente> oc = clienteRepository.findById(idCliente);
            if(oc.isPresent()){
                Cliente cliente = oc.get();
                cliente.getCapi().add(capo);
                clienteRepository.saveAndFlush(cliente);
            }

            res = "OK";
        }catch (Exception e){
            e.printStackTrace();
            res = "KO";
        }
        return res;
    }


}
