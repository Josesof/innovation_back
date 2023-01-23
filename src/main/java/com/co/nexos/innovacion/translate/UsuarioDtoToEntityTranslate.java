package com.co.nexos.innovacion.translate;

import org.springframework.stereotype.Component;

import com.co.nexos.innovacion.dto.UsuarioDTO;
import com.co.nexos.innovacion.entity.Usuario;
import com.co.nexos.innovacion.exception.MsjException;
import com.co.nexos.innovacion.pattern.Translator;

@Component
public class UsuarioDtoToEntityTranslate implements Translator<UsuarioDTO, Usuario> {
	
  @Override
  public Usuario translate(UsuarioDTO input) throws MsjException {
	  
    return Usuario.builder()
    		.idUsuario(input.getIdUsuario())
			.nombres(input.getNombres())
			.apellidos(input.getApellidos())
			.correo(input.getCorreo())
			.password(input.getPassword())
			.estado(input.getEstado())
			.contacto(input.getContacto())
			/*.idCliente(input.getIdCliente())
			.idPermiso(input.getIdPermiso())
			.idRol(input.getIdRol())*/
			.build();
  }
}
