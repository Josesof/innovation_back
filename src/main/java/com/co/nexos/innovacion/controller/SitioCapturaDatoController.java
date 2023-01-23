/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

import com.co.nexos.innovacion.entity.SitioCapturaDato;
import com.co.nexos.innovacion.exception.MsjException;
import com.co.nexos.innovacion.sitiocapturadato.service.ISitioCapturaDatoService;

/**
 *
 * @author jdrivera
 */
@CrossOrigin
@RestController
@RequestMapping(value = "sitioCapturaDato", produces = {MediaType.APPLICATION_JSON_VALUE})
public class SitioCapturaDatoController {

	@Autowired
	private ISitioCapturaDatoService sitioCapturaDatoService; 


    @PostMapping()
    public ResponseEntity<Object> crearSitioCapturaDato(@RequestBody SitioCapturaDato sitioCapturaDato) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(sitioCapturaDatoService.crearSitioCapturaDato(sitioCapturaDato));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
    @GetMapping("/{idSitioCapturaDato}")
    public ResponseEntity<Object> consultarSitioCapturaDatoId(@PathVariable("idSitioCapturaDato") int idSitioCapturaDato) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(sitioCapturaDatoService.consultarSitioCapturaDatoId(idSitioCapturaDato));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }    
    
    @GetMapping()
    public ResponseEntity<Object> consultarSitioCapturaDatoes() {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(sitioCapturaDatoService.consultarSitioCapturaDatos());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
    @DeleteMapping("/{idSitioCapturaDato}")
    public ResponseEntity<Object> eliminarSitioCapturaDato(@PathVariable("idSitioCapturaDato") int idSitioCapturaDato) {
        try {
        	System.out.println();
        	String respuesta = sitioCapturaDatoService.eliminarSitioCapturaDato(idSitioCapturaDato);
        	return ResponseEntity.status(HttpStatus.OK).body(respuesta);
		} catch (MsjException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
}
