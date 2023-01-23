package com.co.nexos.innovacion.variable.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.co.nexos.innovacion.entity.Variable;
import com.co.nexos.innovacion.exception.MsjException;

public interface IVariableService {
	
	public Variable crearVariable(String variable) throws MsjException;
	
	public Variable consultarVariableId(int idVariable) throws MsjException;	
	
	public List<Variable> consultarVariables() throws MsjException;

	public String eliminarVariable(int idVariable) throws MsjException, SQLIntegrityConstraintViolationException;	

}
