package com.co.nexos.innovacion.capturadato.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.co.nexos.innovacion.entity.CapturaDato;

@Repository
public interface ICapturaDatoRepository extends CrudRepository<CapturaDato, Integer> {

}
