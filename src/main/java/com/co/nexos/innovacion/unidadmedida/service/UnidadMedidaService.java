package com.co.nexos.innovacion.unidadmedida.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.nexos.innovacion.entity.UnidadMedida;
import com.co.nexos.innovacion.exception.MsjException;
import com.co.nexos.innovacion.unidadmedida.repository.IUnidadMedidaRepository;

@Service
public class UnidadMedidaService implements IUnidadMedidaService {

	@Autowired
	private IUnidadMedidaRepository unidadMedidaRepository;

	public UnidadMedida crearUnidadMedida(UnidadMedida unidadMedida) {
		return unidadMedidaRepository.save(unidadMedida);
	}

	public UnidadMedida consultarUnidadMedidaId(int idUnidadMedida) throws MsjException {

		Optional<UnidadMedida> unidadMedida = unidadMedidaRepository.findById(idUnidadMedida);
		if (Optional.empty() == null || unidadMedida.isPresent()) {

			return unidadMedida.get();
		} else {
			throw new MsjException("No se pudo encontrar unidad de medida con id: " + idUnidadMedida);
		}
	}

	public List<UnidadMedida> consultarUnidadMedidas() throws MsjException {

		List<UnidadMedida> unidadMedidaes = (List<UnidadMedida>) unidadMedidaRepository.findAll();
		if (!unidadMedidaes.isEmpty()) {
			return unidadMedidaes;
		} else {
			throw new MsjException("No se pudieron encontrar unidad de medidas");
		}
	}

	public String eliminarUnidadMedida(int idUnidadMedida) throws MsjException {

		Optional<UnidadMedida> unidadMedida = unidadMedidaRepository.findById(idUnidadMedida);
		if (unidadMedidaRepository.existsById(idUnidadMedida)) {

			unidadMedidaRepository.deleteById(idUnidadMedida);

			return "UnidadMedida: " + unidadMedida.get().getNombreMedida() + " eliminado";
		} else {
			throw new MsjException("No se pudo eliminar el unidad de medida con id: " + idUnidadMedida);
		}
	}

}
