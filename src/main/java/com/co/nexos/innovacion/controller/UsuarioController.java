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

import com.co.nexos.innovacion.entity.Usuario;
import com.co.nexos.innovacion.exception.MsjException;
import com.co.nexos.innovacion.usuario.service.IUsuarioService;

/**
 *
 * @author jdrivera
 */
@CrossOrigin
@RestController
@RequestMapping(value = "usuario", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService; 

    @PostMapping
    public ResponseEntity<Object> crearUsuario(@RequestBody Usuario usuario) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(usuarioService.crearUsuario(usuario));        	
		} catch (Exception e) {
        	System.out.println();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
    @GetMapping("/{idUsuario}")
    public ResponseEntity<Object> consultarUsuarioId(@PathVariable("idUsuario") int idUsuario) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(usuarioService.consultarUsuarioId(idUsuario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }    
    
    @GetMapping()
    public ResponseEntity<Object> consultarUsuario() {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(usuarioService.consultarUsuarios());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable("idUsuario") int idUsuario) {

        try {
        	System.out.println();
        	String respuesta = usuarioService.eliminarUsuario(idUsuario);
        	return ResponseEntity.status(HttpStatus.OK).body(respuesta);
		} catch (MsjException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
}
