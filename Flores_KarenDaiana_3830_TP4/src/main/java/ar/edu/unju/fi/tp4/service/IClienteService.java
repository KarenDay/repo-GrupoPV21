package ar.edu.unju.fi.tp4.service;

import java.util.List;

import ar.edu.unju.fi.tp4.model.Cliente;

public interface IClienteService {
	
	public void generarTablaClientes();
	
	public Cliente generarCliente();
	
	public void addCliente(Cliente cliente);
	
	public List<Cliente> getListaClientes();
}
