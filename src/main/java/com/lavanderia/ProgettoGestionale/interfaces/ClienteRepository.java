package com.lavanderia.ProgettoGestionale.interfaces;

import com.lavanderia.ProgettoGestionale.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
