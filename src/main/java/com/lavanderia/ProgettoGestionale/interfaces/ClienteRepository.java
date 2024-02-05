package com.lavanderia.ProgettoGestionale.interfaces;

import com.lavanderia.ProgettoGestionale.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByNomeAndCognome(String nome, String cognome);
    Cliente findByCognome(String cognome);

    List<Cliente> findByNome(String nome);
}
