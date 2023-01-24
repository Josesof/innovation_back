package com.co.nexos.innovacion.usuario.service;

import java.util.List;

import com.co.nexos.innovacion.dto.UsuarioDTO;
import com.co.nexos.innovacion.dto.UsuarioInterface;
import com.co.nexos.innovacion.entity.Usuario;
import com.co.nexos.innovacion.exception.MsjException;

public interface IUsuarioService {
	
	public Usuario crearUsuario(Usuario usuario) throws MsjException;
	
	public UsuarioInterface consultarUsuarioId(int idUsuario) throws MsjException;	
	
	public List<Usuario> consultarUsuarios() throws MsjException;

	public String eliminarUsuario(int idUsuario) throws MsjException;	

}
