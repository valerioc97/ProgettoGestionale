package com.lavanderia.ProgettoGestionale.interfaces;

import com.lavanderia.ProgettoGestionale.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByNomeAndCognome(String nome, String cognome);
    Cliente findByCognome(String cognome);

    List<Cliente> findByNome(String nome);

    @Modifying
    @Transactional
    @Query(value = "UPDATE lavanderia.cliente SET nome = ?, cognome = ?, indirizzo = ?, numero_di_telefono = ? WHERE id_cliente = ?;", nativeQuery = true)
    void updateClienteByclienteEntityAndIdCliente(String nome, String cognome, String indirizzo, String numeroDiTelefono, Integer idCliente);
}
