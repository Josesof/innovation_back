package com.co.nexos.innovacion.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.nexos.innovacion.entity.Variable;
import com.co.nexos.innovacion.exception.MsjException;
import com.co.nexos.innovacion.variable.service.IVariableService;
import com.google.gson.Gson;

/**
 *
 * @author jdrivera
 */
@CrossOrigin
@RestController
@RequestMapping(value = "variable", produces = {MediaType.APPLICATION_JSON_VALUE})
public class VariableController{

	@Autowired
	private IVariableService variableService; 


    @PostMapping()
    public ResponseEntity<Object> crearVariable(@RequestBody String variable) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(variableService.crearVariable(variable));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
    @GetMapping("/{idVariable}")
    public ResponseEntity<Object> consultarVariableId(@PathVariable("idVariable") int idVariable) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(variableService.consultarVariableId(idVariable));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }    
    
    @GetMapping()
    public ResponseEntity<Object> consultarVariablees() {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(variableService.consultarVariables());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
    @DeleteMapping
    public ResponseEntity<Object> eliminarVariable(@RequestBody String idVariable) {
    	Gson gson = new Gson();
    	JSONObject objVariable = gson.fromJson(idVariable, JSONObject.class);
        try {
        	System.out.println();
        	String respuesta = variableService.eliminarVariable(Integer.parseInt(objVariable.get("idVariable").toString()));
        	return ResponseEntity.status(HttpStatus.OK).body(respuesta);
		} catch (MsjException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
        
    }
}
