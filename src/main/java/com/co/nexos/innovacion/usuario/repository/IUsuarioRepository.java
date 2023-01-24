package com.co.nexos.innovacion.usuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.co.nexos.innovacion.dto.UsuarioInterface;
import com.co.nexos.innovacion.entity.Usuario;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Transactional
	@Modifying
	@Query(value = "delete from usuarios u where u.id_usuario = :idUsuario", nativeQuery = true)
	public void deleteUsuarioById(@Param("idUsuario") int idUsuario);
	

	@Transactional
	@Query(value = "SELECT " +
			"usr.id_usuario AS idUsuario," + 
			"usr.nombres AS nombreUsuario," + 
			"usr.apellidos AS apellidoUsuario," + 
			"usr.correo AS correoUsuario," + 
			"usr.contacto AS contactoUsuario," + 
			"usr.estado AS estadoUsuario," + 
			"cli.id_cliente AS idCliente," + 
			"cli.nombre AS nombreCliente," + 
			"cli.correo AS correoCliente," + 
			"cli.permiso AS permisoCliente," + 
			"rol.id_rol AS idRol," + 
			"rol.nombre_rol AS nombreRol " + 
			"FROM usuarios usr  " + 
			"JOIN clientes cli ON usr.id_cliente = cli.id_cliente " + 
			"JOIN permisos per ON usr.id_permiso = per.id_permiso " + 
			"JOIN roles rol ON usr.id_rol = rol.id_rol " +
			"WHERE usr.id_usuario = :idUsuario", nativeQuery = true)
	public List<UsuarioInterface> getUsuarioById(@Param("idUsuario") int idUsuario);	
	
}
