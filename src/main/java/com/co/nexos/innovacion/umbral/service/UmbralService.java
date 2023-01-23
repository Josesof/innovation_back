package com.co.nexos.innovacion.umbral.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.nexos.innovacion.entity.Umbral;
import com.co.nexos.innovacion.exception.MsjException;
import com.co.nexos.innovacion.umbral.repository.IUmbralRepository;
import com.google.gson.Gson;

@Service
public class UmbralService implements IUmbralService {

	@Autowired
	private IUmbralRepository umbralRepository;

	public Umbral crearUmbral(String umbralStr) throws MsjException {
		Gson gson = new Gson();
		Umbral umbral = gson.fromJson(umbralStr, Umbral.class); 
		try {
			return umbralRepository.save(umbral);
		} catch (Exception e) {
			System.out.println();
			throw new MsjException("El umbral : " + umbral.getIdUmbrales() + ", no se guardo correctamente");
		}

	}

	public Umbral consultarUmbralId(int idUmbral) throws MsjException {

		Optional<Umbral> umbral = umbralRepository.findById(idUmbral);
		if (Optional.empty() == null || umbral.isPresent()) {

			return umbral.get();
		} else {
			throw new MsjException("No se pudo encontrar umbral con id: " + idUmbral);
		}
	}

	public List<Umbral> consultarUmbrals() throws MsjException {

		List<Umbral> umbrals = (List<Umbral>) umbralRepository.findAll();
		
		System.out.println("lstUmbral: " + umbrals);
		if (!umbrals.isEmpty()) {
			return umbrals;
		} else {
			throw new MsjException("No se pudieron encontrar umbrales");
		}
	}

	public String eliminarUmbral(int idUmbral) throws MsjException {

		Optional<Umbral> umbral = umbralRepository.findById(idUmbral);
		if (umbralRepository.existsById(idUmbral)) {
			umbralRepository.deleteById(idUmbral);
			return "Umbral: " + umbral.get().getIdUmbrales() + " eliminado";
		} else {
			throw new MsjException("No se pudo eliminar el umbral con id: " + idUmbral);
		}
	}

}
