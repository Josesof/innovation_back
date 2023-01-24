package com.co.nexos.innovacion.cliente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.co.nexos.innovacion.dto.ClienteInterface;
import com.co.nexos.innovacion.entity.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Integer> {

	
	@Transactional
	@Query(value = "SELECT " +
			"cli.id_cliente AS idCliente," + 
			"cli.nombre AS nombre," + 
			"cli.correo AS correo," + 
			"cli.contacto AS contacto," + 
			"cli.permiso AS permiso," + 
			"var.id_variable AS idVariable," + 
			"var.nombre_variable AS nombreVariable," + 
			"var.estado AS estado," + 
			"var.tiempo_muestreo AS tiempoMuestreo," + 
			"udmed.id_unidad_medida AS idUnidadMedida," + 
			"udmed.nombre_medida AS nombreMedida " +
			"FROM clientes cli " + 
			"JOIN clientes_has_variables cli_var ON cli.id_cliente = cli_var.id_cliente " + 
			"JOIN variables var ON var.id_variable = cli_var.id_variable " + 
			"JOIN unidadesmedida udmed ON udmed.id_unidad_medida = var.id_unidad_medida " +
			"WHERE cli.id_cliente = :idCliente", nativeQuery = true)
	public List<ClienteInterface> getClienteById(@Param("idCliente") int idCliente);
	
	@Transactional
	@Query(value = "SELECT " +
			"cli.id_cliente idCliente," + 
			"cli.nombre nombre," + 
			"cli.correo correo," + 
			"cli.contacto contacto," + 
			"cli.permiso permiso," + 
			"var.id_variable idVariable," + 
			"var.nombre_variable nombreVariable," + 
			"var.estado estado," + 
			"var.tiempo_muestreo tiempoMuestreo," + 
			"udmed.id_unidad_medida idUnidadMedida," + 
			"udmed.nombre_medida nombreMedida " +
			"FROM clientes cli " + 
			"JOIN clientes_has_variables cli_var ON cli.id_cliente = cli_var.id_cliente " + 
			"JOIN variables var ON var.id_variable = cli_var.id_variable " + 
			"JOIN unidadesmedida udmed ON udmed.id_unidad_medida = var.id_unidad_medida " +
			"WHERE cli.id_cliente = :idCliente", nativeQuery = true)
	public String getClienteById1(@Param("idCliente") int idCliente);
	
	@Transactional
	@Query(value = "SELECT " +
			"cli.id_cliente idCliente," + 
			"cli.nombre nombre," + 
			"cli.correo correo," + 
			"cli.contacto contacto," + 
			"cli.permiso permiso," + 
			"var.id_variable idVariable," + 
			"var.nombre_variable nombreVariable," + 
			"var.estado estado," + 
			"var.tiempo_muestreo tiempoMuestreo," + 
			"udmed.id_unidad_medida idUnidadMedida," + 
			"udmed.nombre_medida nombreMedida " +
			"FROM clientes cli " + 
			"JOIN clientes_has_variables cli_var ON cli.id_cliente = cli_var.id_cliente " + 
			"JOIN variables var ON var.id_variable = cli_var.id_variable " + 
			"JOIN unidadesmedida udmed ON udmed.id_unidad_medida = var.id_unidad_medida " +
			"WHERE cli.id_cliente = :idCliente", nativeQuery = true)
	public Object getClienteById2(@Param("idCliente") int idCliente);
}
