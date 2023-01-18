package com.co.nexos.innovacion.controller;

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

import com.co.nexos.innovacion.entity.Rol;
import com.co.nexos.innovacion.exception.MsjException;
import com.co.nexos.innovacion.rol.service.IRolService;
import com.google.gson.Gson;
import org.json.simple.JSONObject;   

/**
 *
 * @author jdrivera
 */
@CrossOrigin
@RestController
@RequestMapping(value = "rol", produces = {MediaType.APPLICATION_JSON_VALUE})
public class RolController {
	
	@Autowired
	private IRolService rolService; 


    @PostMapping()
    public ResponseEntity<Object> crearRol(@RequestBody Rol rol) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(rolService.crearRol(rol));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
    @GetMapping("/{idRol}")
    public ResponseEntity<Object> consultarRolId(@PathVariable("idRol") int idRol) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(rolService.consultarRolId(idRol));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }    
    
    @GetMapping()
    public ResponseEntity<Object> consultarRoles() {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(rolService.consultarRoles());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
    @DeleteMapping
    public ResponseEntity<Object> eliminarRol(@RequestBody String idRol) {
    	Gson gson = new Gson();
    	JSONObject objRol = gson.fromJson(idRol, JSONObject.class);
    	;
        try {
        	System.out.println();
        	String respuesta = rolService.eliminarRol(Integer.parseInt(objRol.get("idRol").toString()));
        	return ResponseEntity.status(HttpStatus.OK).body(respuesta);
		} catch (MsjException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
}
