package com.co.nexos.innovacion.variable.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.co.nexos.innovacion.entity.Variable;

@Repository
public interface IVariableRepository extends CrudRepository<Variable, Integer> {

}
