package com.co.nexos.innovacion.cliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.nexos.innovacion.cliente.repository.IClienteRepository;
import com.co.nexos.innovacion.entity.Cliente;
import com.co.nexos.innovacion.exception.MsjException;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	public Cliente crearCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente consultarClienteId(int idCliente) throws MsjException {

		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		if (Optional.empty() == null || cliente.isPresent()) {

			return cliente.get();
		} else {
			throw new MsjException("No se pudo encontrar cliente con id: " + idCliente);
		}
	}

	public List<Cliente> consultarClientes() throws MsjException {

		List<Cliente> clientees = (List<Cliente>) clienteRepository.findAll();
		if (!clientees.isEmpty()) {
			return clientees;
		} else {
			throw new MsjException("No se pudieron encontrar clientes");
		}
	}

	public String eliminarCliente(int idCliente) throws MsjException {

		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		if (clienteRepository.existsById(idCliente)) {

			clienteRepository.deleteById(idCliente);

			return "Cliente: " + cliente.get().getNombre() + " eliminado";
		} else {
			throw new MsjException("No se pudo eliminar el cliente con id: " + idCliente);
		}
	}

}
