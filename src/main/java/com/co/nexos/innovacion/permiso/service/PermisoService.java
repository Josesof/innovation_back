package com.co.nexos.innovacion.permiso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.nexos.innovacion.entity.Permiso;
import com.co.nexos.innovacion.exception.MsjException;
import com.co.nexos.innovacion.permiso.repository.IPermisoRepository;

@Service
public class PermisoService implements IPermisoService {

	@Autowired
	private IPermisoRepository permisoRepository;

	public Permiso crearPermiso(Permiso permiso) {
		return permisoRepository.save(permiso);
	}

	public Permiso consultarPermisoId(int idPermiso) throws MsjException {

		Optional<Permiso> permiso = permisoRepository.findById(idPermiso);
		if (Optional.empty() == null || permiso.isPresent()) {

			return permiso.get();
		} else {
			throw new MsjException("No se pudo encontrar permiso con id: " + idPermiso);
		}
	}

	public List<Permiso> consultarPermisos() throws MsjException {

		List<Permiso> permisoes = (List<Permiso>) permisoRepository.findAll();
		if (!permisoes.isEmpty()) {
			return permisoes;
		} else {
			throw new MsjException("No se pudieron encontrar permisos");
		}
	}

	public String eliminarPermiso(int idPermiso) throws MsjException {

		Optional<Permiso> permiso = permisoRepository.findById(idPermiso);
		if (permisoRepository.existsById(idPermiso)) {

			permisoRepository.deleteById(idPermiso);

			return "Permiso: " + permiso.get().getNombrePermiso() + " eliminado";
		} else {
			throw new MsjException("No se pudo eliminar el permiso con id: " + idPermiso);
		}
	}

}
