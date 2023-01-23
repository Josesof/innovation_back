package com.co.nexos.innovacion.sensor.service;

import java.util.List;

import com.co.nexos.innovacion.entity.Sensor;
import com.co.nexos.innovacion.exception.MsjException;

public interface ISensorService {
	
	public Sensor crearSensor(Sensor sensor) throws MsjException;
	
	public Sensor consultarSensorId(int idSensor) throws MsjException;	
	
	public List<Sensor> consultarSensors() throws MsjException;

	public String eliminarSensor(int idSensor) throws MsjException;	

}
