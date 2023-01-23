package com.co.nexos.innovacion.sensor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.nexos.innovacion.entity.Sensor;
import com.co.nexos.innovacion.exception.MsjException;
import com.co.nexos.innovacion.sensor.repository.ISensorRepository;

@Service
public class SensorService implements ISensorService {

	@Autowired
	private ISensorRepository sensorRepository;

	public Sensor crearSensor(Sensor sensor) throws MsjException {
		try {
			return sensorRepository.save(sensor);
		} catch (Exception e) {
			System.out.println();
			throw new MsjException("El sensor: " + sensor.getNombreSensor() + ", no se guardo correctamente");
		}
	}

	public Sensor consultarSensorId(int idSensor) throws MsjException {

		Optional<Sensor> sensor = sensorRepository.findById(idSensor);
		if (Optional.empty() == null || sensor.isPresent()) {

			return sensor.get();
		} else {
			throw new MsjException("No se pudo encontrar sensor con id: " + idSensor);
		}
	}

	public List<Sensor> consultarSensors() throws MsjException {

		List<Sensor> sensores = (List<Sensor>) sensorRepository.findAll();
		if (!sensores.isEmpty()) {
			return sensores;
		} else {
			throw new MsjException("No se pudieron encontrar sensores");
		}
	}

	public String eliminarSensor(int idSensor) throws MsjException {

		Optional<Sensor> sensor = sensorRepository.findById(idSensor);
		if (sensorRepository.existsById(idSensor)) {

			sensorRepository.deleteById(idSensor);

			return "Sensor: " + sensor.get().getNombreSensor() + " eliminado";
		} else {
			throw new MsjException("No se pudo eliminar el sensor con id: " + idSensor);
		}
	}

}
