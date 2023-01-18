package com.co.nexos.innovacion.usuario.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.co.nexos.innovacion.entity.Usuario;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "delete from usuarios u where u.id_usuario = :idUsuario", nativeQuery = true)
	public void deleteUsuarioById(@Param("idUsuario") int idUsuario);
}
