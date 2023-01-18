package com.co.nexos.innovacion.rol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.nexos.innovacion.entity.Rol;
import com.co.nexos.innovacion.exception.MsjException;
import com.co.nexos.innovacion.rol.repository.IRolRepository;

@Service
public class RolService implements IRolService{
	
	@Autowired
	private IRolRepository rolRepository;

	public Rol crearRol(Rol rol) {
		return rolRepository.save(rol);			
	}

	public Rol consultarRolId(int idRol) throws MsjException {
		
		Optional<Rol> rol = rolRepository.findById(idRol);
		if (Optional.empty() == null || rol.isPresent()) {	

			return rol.get();
		} else {
			throw new MsjException("No se pudo encontrar rol con id: " + idRol);
		}		
	}

	public List<Rol> consultarRoles() throws MsjException {
		
		List<Rol> roles = (List<Rol>) rolRepository.findAll();
		if (!roles.isEmpty()) {	
			return roles;
		} else {
			throw new MsjException("No se pudieron encontrar roles");
		}		
	}

	public String eliminarRol(int idRol) throws MsjException {
		
		Optional<Rol> rol = rolRepository.findById(idRol);
		if (rolRepository.existsById(idRol)) {
			
			rolRepository.deleteById(idRol);

			return "Rol: " + rol.get().getNombreRol() + " eliminado";
		} else {
			throw new MsjException("No se pudo eliminar el rol con id: " + idRol);
		}		
	}

}
