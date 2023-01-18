package com.co.nexos.innovacion.cliente.service;

import java.util.List;

import com.co.nexos.innovacion.entity.Cliente;
import com.co.nexos.innovacion.exception.MsjException;

public interface IClienteService {
	
	public Cliente crearCliente(Cliente cliente);
	
	public Cliente consultarClienteId(int idCliente) throws MsjException;	
	
	public List<Cliente> consultarClientes() throws MsjException;

	public String eliminarCliente(int idCliente) throws MsjException;	

}
