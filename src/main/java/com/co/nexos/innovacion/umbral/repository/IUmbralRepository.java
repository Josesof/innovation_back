package com.co.nexos.innovacion.umbral.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.co.nexos.innovacion.entity.Umbral;

@Repository
public interface IUmbralRepository extends CrudRepository<Umbral, Integer> {
	
	/*@Transactional
	@Modifying
	@Query(value = "delete from usuarios u where u.id_usuario = :idUsuario", nativeQuery = true)
	public void deleteUsuarioById(@Param("idUsuario") int idUsuario);*/
}
