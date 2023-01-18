package com.co.nexos.innovacion.umbral.service;

import java.util.List;

import com.co.nexos.innovacion.entity.Umbral;
import com.co.nexos.innovacion.exception.MsjException;

public interface IUmbralService {
	
	public Umbral crearUmbral(String usuario) throws MsjException;
	
	public Umbral consultarUmbralId(int idUmbral) throws MsjException;	
	
	public List<Umbral> consultarUmbrals() throws MsjException;

	public String eliminarUmbral(int idUmbral) throws MsjException;	

}
