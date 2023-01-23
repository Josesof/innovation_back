package com.co.nexos.innovacion.variable.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.co.nexos.innovacion.entity.Variable;
import com.co.nexos.innovacion.exception.MsjException;
import com.co.nexos.innovacion.variable.repository.IVariableRepository;
import com.google.gson.Gson;

@Service
public class VariableService implements IVariableService {

	@Autowired
	private IVariableRepository variableRepository;

	public Variable crearVariable(String variableStr) throws MsjException {
		Gson gson = new Gson();
		Variable variable = gson.fromJson(variableStr, Variable.class);
		try {
			return variableRepository.save(variable);
		} catch (Exception e) {
			System.out.println();
			throw new MsjException("La variable: " + variable.getNombreVariable() + ", no se guardo correctamente");
		}
	}

	public Variable consultarVariableId(int idVariable) throws MsjException {

		Optional<Variable> variable = variableRepository.findById(idVariable);
		if (Optional.empty() == null || variable.isPresent()) {

			return variable.get();
		} else {
			throw new MsjException("No se pudo encontrar variable con id: " + idVariable);
		}
	}

	public List<Variable> consultarVariables() throws MsjException {

		List<Variable> variables = (List<Variable>) variableRepository.findAll();
		if (!variables.isEmpty()) {
			return variables;
		} else {
			throw new MsjException("No se pudieron encontrar unidad de medidas");
		}
	}

	public String eliminarVariable(int idVariable) throws MsjException, SQLIntegrityConstraintViolationException {

		try {
			Optional<Variable> variable = variableRepository.findById(idVariable);
			if (variableRepository.existsById(idVariable)) {
				variableRepository.deleteById(idVariable);
				return "Variable: " + variable.get().getNombreVariable() + " eliminado";
			} else {
				throw new MsjException("No se pudo eliminar el unidad de medida con id: " + idVariable);
			}
		} catch (DataIntegrityViolationException e) {
			throw new MsjException("No se pudo eliminar el unidad de medida con id: " + idVariable + ". identificador usado en otro registro.");
		}
	}		

}
