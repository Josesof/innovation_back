package com.co.nexos.innovacion.unidadmedida.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.co.nexos.innovacion.entity.UnidadMedida;

@Repository
public interface IUnidadMedidaRepository extends CrudRepository<UnidadMedida, Integer> {

}
