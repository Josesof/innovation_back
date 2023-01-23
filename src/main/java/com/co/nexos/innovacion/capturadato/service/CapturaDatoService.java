package com.co.nexos.innovacion.capturadato.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.nexos.innovacion.capturadato.repository.ICapturaDatoRepository;
import com.co.nexos.innovacion.entity.CapturaDato;
import com.co.nexos.innovacion.exception.MsjException;

@Service
public class CapturaDatoService implements ICapturaDatoService {

	@Autowired
	private ICapturaDatoRepository capturaDatoRepository;

	public CapturaDato crearCapturaDato(CapturaDato capturaDato) throws MsjException {
		try {
			return capturaDatoRepository.save(capturaDato);
		} catch (Exception e) {
			System.out.println();
			throw new MsjException("La capturaDato: " + capturaDato.getNombre() + ", no se guardo correctamente");
		}
	}

	public CapturaDato consultarCapturaDatoId(int idCapturaDato) throws MsjException {

		Optional<CapturaDato> capturaDato = capturaDatoRepository.findById(idCapturaDato);
		if (Optional.empty() == null || capturaDato.isPresent()) {

			return capturaDato.get();
		} else {
			throw new MsjException("No se pudo encontrar capturaDato con id: " + idCapturaDato);
		}
	}

	public List<CapturaDato> consultarCapturaDatos() throws MsjException {

		List<CapturaDato> capturaDatoes = (List<CapturaDato>) capturaDatoRepository.findAll();
		if (!capturaDatoes.isEmpty()) {
			return capturaDatoes;
		} else {
			throw new MsjException("No se pudieron encontrar unidad de medidas");
		}
	}

	public String eliminarCapturaDato(int idCapturaDato) throws MsjException {

		Optional<CapturaDato> capturaDato = capturaDatoRepository.findById(idCapturaDato);
		if (capturaDatoRepository.existsById(idCapturaDato)) {

			capturaDatoRepository.deleteById(idCapturaDato);

			return "CapturaDato: " + capturaDato.get().getNombre() + " eliminado";
		} else {
			throw new MsjException("No se pudo eliminar el unidad de medida con id: " + idCapturaDato);
		}
	}

}
