package com.co.nexos.innovacion.sitiocapturadato.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.co.nexos.innovacion.entity.SitioCapturaDato;

@Repository
public interface ISitioCapturaDatoRepository extends CrudRepository<SitioCapturaDato, Integer> {

}
