package com.lavanderia.ProgettoGestionale.services;

import com.lavanderia.ProgettoGestionale.interfaces.ClienteRepository;
import com.lavanderia.ProgettoGestionale.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClienti(){
        return clienteRepository.findAll();
    }

    public Cliente findCliente(Integer id){
        Optional<Cliente> op = clienteRepository.findById(id);
        return op.isPresent() ? op.get() : new Cliente();
    }

    public String postCliente(Cliente cliente){
        String res = null;
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
        String res = null;
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
        String res = null;

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
        String res = null;
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
}
