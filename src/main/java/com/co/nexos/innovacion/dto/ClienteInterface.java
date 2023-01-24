package com.co.nexos.innovacion.dto;

/**
 *
 * @author jdrivera
 */
public interface ClienteInterface {

	Integer getIdCliente();
	String getNombre();
	String getCorreo();
	String getContacto();
	String getPermiso();
	Integer getIdVariable();
	String getNombreVariable();
	String getEstado();
	Integer getTiempoMuestreo();
	Integer getIdUnidadMedida();
	String getNombreMedida();
}
