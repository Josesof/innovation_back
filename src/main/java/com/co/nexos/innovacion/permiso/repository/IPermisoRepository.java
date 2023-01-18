package com.co.nexos.innovacion.permiso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.co.nexos.innovacion.entity.Permiso;

@Repository
public interface IPermisoRepository extends CrudRepository<Permiso, Integer> {

}
