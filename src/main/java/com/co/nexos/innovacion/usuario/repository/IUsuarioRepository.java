package com.co.nexos.innovacion.usuario.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.co.nexos.innovacion.dto.UsuarioDTO;
import com.co.nexos.innovacion.entity.Usuario;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Transactional
	@Modifying
	@Query(value = "delete from usuarios u where u.id_usuario = :idUsuario", nativeQuery = true)
	public void deleteUsuarioById(@Param("idUsuario") int idUsuario);
	

	@Transactional
	@Query(value = "select usr.id_usuario as idUsuario, " + 
			"	usr.nombres as nombreUsuario, " + 
			"	usr.apellidos as apellidoUsuario, " + 
			"	usr.correo as correoUsuario, " + 
			"	usr.contacto as contactoUsuario, " + 
			"	usr.estado as estadoUsuario, " + 
			"    cli.id_cliente as idCliente, " + 
			"    cli.nombre as nombreCliente, " + 
			"    cli.correo as correoCliente, " + 
			"    cli.permiso as permisoCliente, " + 
			"    rol.id_rol as idRol, " + 
			"    rol.nombre_rol as nombreRol " + 
			"    from usuarios usr  " + 
			"inner join clientes cli on usr.id_cliente = cli.id_cliente " + 
			"inner join permisos per on usr.id_permiso = per.id_permiso " + 
			"inner join roles rol on usr.id_rol = rol.id_rol "
			+ "where usr.id_usuario = :idUsuario", nativeQuery = true)
	public com.co.nexos.innovacion.dto.UsuarioInterface getUsuarioById(@Param("idUsuario") int idUsuario);	
	
}
