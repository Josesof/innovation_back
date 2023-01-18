package com.co.nexos.innovacion.cliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.co.nexos.innovacion.entity.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Integer> {

}
