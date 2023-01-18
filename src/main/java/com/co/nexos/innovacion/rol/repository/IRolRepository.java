package com.co.nexos.innovacion.rol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.co.nexos.innovacion.entity.Rol;

@Repository
public interface IRolRepository extends CrudRepository<Rol, Integer> {

}
