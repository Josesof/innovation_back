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

import com.co.nexos.innovacion.entity.Permiso;
import com.co.nexos.innovacion.exception.MsjException;
import com.co.nexos.innovacion.permiso.service.IPermisoService;
import com.google.gson.Gson;

/**
 *
 * @author jdrivera
 */
@CrossOrigin
@RestController
@RequestMapping(value = "permiso", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PermisoController {

	@Autowired
	private IPermisoService permisoService;

    @PostMapping()
    public ResponseEntity<Object> crearPermiso(@RequestBody Permiso permiso) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(permisoService.crearPermiso(permiso));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
    @GetMapping("/{idPermiso}")
    public ResponseEntity<Object> consultarPermisoId(@PathVariable("idPermiso") int idPermiso) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(permisoService.consultarPermisoId(idPermiso));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }    
    
    @GetMapping()
    public ResponseEntity<Object> consultarPermisoes() {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(permisoService.consultarPermisos());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
    @DeleteMapping
    public ResponseEntity<Object> eliminarPermiso(@RequestBody String idPermiso) {
    	Gson gson = new Gson();
    	JSONObject objPermiso = gson.fromJson(idPermiso, JSONObject.class);
    	;
        try {
        	System.out.println();
        	String respuesta = permisoService.eliminarPermiso(Integer.parseInt(objPermiso.get("idPermiso").toString()));
        	return ResponseEntity.status(HttpStatus.OK).body(respuesta);
		} catch (MsjException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
}
