package com.co.nexos.innovacion.dto;

import java.io.Serializable;

import com.co.nexos.innovacion.entity.Cliente;
import com.co.nexos.innovacion.entity.Permiso;
import com.co.nexos.innovacion.entity.Rol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jdrivera
 */
public class UsuarioDTO {
    
    private Integer idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String correoUsuario;
    private String contactoUsuario;
    private Integer estadoUsuario;
    private Integer idCliente;
    private String nombreCliente;
    private String correoCliente;
    private String permisoCliente;
    private Integer idRol;
    private String nombreRol;
    
    
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellidoUsuario() {
		return apellidoUsuario;
	}
	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}
	public String getCorreoUsuario() {
		return correoUsuario;
	}
	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}
	public String getContactoUsuario() {
		return contactoUsuario;
	}
	public void setContactoUsuario(String contactoUsuario) {
		this.contactoUsuario = contactoUsuario;
	}
	public Integer getEstadoUsuario() {
		return estadoUsuario;
	}
	public void setEstadoUsuario(Integer estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getCorreoCliente() {
		return correoCliente;
	}
	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}
	public String getPermisoCliente() {
		return permisoCliente;
	}
	public void setPermisoCliente(String permisoCliente) {
		this.permisoCliente = permisoCliente;
	}
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	public UsuarioDTO(Integer idUsuario, String nombreUsuario, String apellidoUsuario, String correoUsuario,
			String contactoUsuario, Integer estadoUsuario, Integer idCliente, String nombreCliente,
			String correoCliente, String permisoCliente, Integer idRol, String nombreRol) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.correoUsuario = correoUsuario;
		this.contactoUsuario = contactoUsuario;
		this.estadoUsuario = estadoUsuario;
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.correoCliente = correoCliente;
		this.permisoCliente = permisoCliente;
		this.idRol = idRol;
		this.nombreRol = nombreRol;
	}
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UsuarioDTO [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", apellidoUsuario="
				+ apellidoUsuario + ", correoUsuario=" + correoUsuario + ", contactoUsuario=" + contactoUsuario
				+ ", estadoUsuario=" + estadoUsuario + ", idCliente=" + idCliente + ", nombreCliente=" + nombreCliente
				+ ", correoCliente=" + correoCliente + ", permisoCliente=" + permisoCliente + ", idRol=" + idRol
				+ ", nombreRol=" + nombreRol + "]";
	}
	
	
	
	
        
}
