package com.co.nexos.innovacion.capturadato.service;

import java.util.List;

import com.co.nexos.innovacion.entity.CapturaDato;
import com.co.nexos.innovacion.exception.MsjException;

public interface ICapturaDatoService {
	
	public CapturaDato crearCapturaDato(CapturaDato capturaDato) throws MsjException;
	
	public CapturaDato consultarCapturaDatoId(int idCapturaDato) throws MsjException;	
	
	public List<CapturaDato> consultarCapturaDatos() throws MsjException;

	public String eliminarCapturaDato(int idCapturaDato) throws MsjException;	

}
