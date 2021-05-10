package ar.edu.unju.fi.tp4.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import ar.edu.unju.fi.tp4.model.Cliente;
import ar.edu.unju.fi.tp4.service.IClienteService;
import ar.edu.unju.fi.tp4.util.TablaClientes;
/** 
 * 
 * @author Karen Flores
 *
 */
@Service("clienteUtilService")
public class ClienteServiceImp implements IClienteService{
	
	private static final Log LOGGER = LogFactory.getLog(ClienteServiceImp.class);
	
	
	@Autowired
	@Qualifier("unCliente")
	private Cliente cliente;
	
	private List<Cliente> clientes;
	
	@Override
	public void addCliente(Cliente cliente) {
		LOGGER.info("SERVICE: ClienteServiceImp");
		LOGGER.info("METHOD: addCliente() con objeto del tipo Cliente como parametro");
		LOGGER.info("RESULT: agrega un cliente a la lista de clientes");
		if (clientes==null) {
			generarTablaClientes();
		}	
		
			clientes.add(cliente);
		LOGGER.info("Cliente agregado a la lista");	
	}

	@Override
	public List<Cliente> getListaClientes() {
		LOGGER.info("SERVICE: ClienteServiceImp");
		LOGGER.info("METHOD: getListaClientes() ");
		LOGGER.info("RESULT: devuelve la lista de clientes");
		
		if (clientes==null) 
			generarTablaClientes();
		LOGGER.info("Cantidad de clientes en la lista:" +clientes.size());
		return clientes;
		
	}

	@Override
	public void generarTablaClientes() {
		LOGGER.info("SERVICE: ClienteServiceImp");
		LOGGER.info("METHOD: generarTablaClientes()");
		
		clientes = TablaClientes.listaClientes;
		Cliente nuevo = new Cliente("DNI",123456789,"Pipo Flores","pipo@gmail.com","1234",LocalDate.of(2010, 8, 12),388,5197089,LocalDate.of(2021, 4, 16));
		clientes.add(nuevo);
		
	}

	@Override
	public Cliente generarCliente() {
		LOGGER.info("SERVICE: ClienteServiceImp");
		LOGGER.info("METHOD: generarCliente()");
		
		return cliente;
	}

}
