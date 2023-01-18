package com.co.nexos.innovacion.rol.service;

import java.util.List;

import com.co.nexos.innovacion.entity.Rol;
import com.co.nexos.innovacion.exception.MsjException;

public interface IRolService {
	
	public Rol crearRol(Rol rol);
	
	public Rol consultarRolId(int idRol) throws MsjException;	
	
	public List<Rol> consultarRoles() throws MsjException;

	public String eliminarRol(int idRol) throws MsjException;	

}
