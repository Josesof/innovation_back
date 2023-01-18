package com.co.nexos.innovacion.sitiocapturadato.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.nexos.innovacion.entity.SitioCapturaDato;
import com.co.nexos.innovacion.exception.MsjException;
import com.co.nexos.innovacion.sitiocapturadato.repository.ISitioCapturaDatoRepository;

@Service
public class SitioCapturaDatoService implements ISitioCapturaDatoService {

	@Autowired
	private ISitioCapturaDatoRepository sitioCapturaDatoRepository;

	public SitioCapturaDato crearSitioCapturaDato(SitioCapturaDato sitioCapturaDato) {
		return sitioCapturaDatoRepository.save(sitioCapturaDato);
	}

	public SitioCapturaDato consultarSitioCapturaDatoId(int idSitioCapturaDato) throws MsjException {

		Optional<SitioCapturaDato> sitioCapturaDato = sitioCapturaDatoRepository.findById(idSitioCapturaDato);
		if (Optional.empty() == null || sitioCapturaDato.isPresent()) {

			return sitioCapturaDato.get();
		} else {
			throw new MsjException("No se pudo encontrar sitioCapturaDato con id: " + idSitioCapturaDato);
		}
	}

	public List<SitioCapturaDato> consultarSitioCapturaDatos() throws MsjException {

		List<SitioCapturaDato> sitioCapturaDatoes = (List<SitioCapturaDato>) sitioCapturaDatoRepository.findAll();
		if (!sitioCapturaDatoes.isEmpty()) {
			return sitioCapturaDatoes;
		} else {
			throw new MsjException("No se pudieron encontrar sitioCapturaDatos");
		}
	}

	public String eliminarSitioCapturaDato(int idSitioCapturaDato) throws MsjException {

		Optional<SitioCapturaDato> sitioCapturaDato = sitioCapturaDatoRepository.findById(idSitioCapturaDato);
		if (sitioCapturaDatoRepository.existsById(idSitioCapturaDato)) {

			sitioCapturaDatoRepository.deleteById(idSitioCapturaDato);

			return "SitioCapturaDato: " + sitioCapturaDato.get().getNombreSitio() + " eliminado";
		} else {
			throw new MsjException("No se pudo eliminar el sitio captura dato con id: " + idSitioCapturaDato);
		}
	}

}
