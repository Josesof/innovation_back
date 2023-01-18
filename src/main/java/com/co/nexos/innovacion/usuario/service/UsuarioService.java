package com.co.nexos.innovacion.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.nexos.innovacion.entity.Usuario;
import com.co.nexos.innovacion.exception.MsjException;
import com.co.nexos.innovacion.usuario.repository.IUsuarioRepository;
import com.google.gson.Gson;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	public Usuario crearUsuario(String usuarioStr) throws MsjException {
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(usuarioStr, Usuario.class); 
		try {
			return usuarioRepository.save(usuario);
		} catch (Exception e) {
			System.out.println();
			throw new MsjException("El usuario : " + usuario.getNombres() + ", no se guardo correctamente");
		}

	}

	public Usuario consultarUsuarioId(int idUsuario) throws MsjException {

		Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
		if (Optional.empty() == null || usuario.isPresent()) {

			return usuario.get();
		} else {
			throw new MsjException("No se pudo encontrar usuario con id: " + idUsuario);
		}
	}

	public List<Usuario> consultarUsuarios() throws MsjException {

		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
		if (!usuarios.isEmpty()) {
			return usuarios;
		} else {
			throw new MsjException("No se pudieron encontrar usuarios");
		}
	}

	public String eliminarUsuario(int idUsuario) throws MsjException {

		Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
		if (usuarioRepository.existsById(idUsuario)) {
			usuarioRepository.deleteUsuarioById(idUsuario);
			return "Usuario: " + usuario.get().getNombres() + " eliminado";
		} else {
			throw new MsjException("No se pudo eliminar el usuario con id: " + idUsuario);
		}
	}

}
