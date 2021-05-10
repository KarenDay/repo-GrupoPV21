package ar.edu.unju.fi.tp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.model.Cliente;
import ar.edu.unju.fi.tp4.service.IClienteService;
/**
 * 
 * @author Karen Flores
 *
 */
@Controller
public class ClienteController {
	
	
	@Autowired
	@Qualifier("clienteUtilService")
	private IClienteService clienteService;
	
	
	@GetMapping("/cliente/nuevo")
	public String nuevoClientePage(Model model) {
		
		model.addAttribute("clienteNuevo", clienteService.generarCliente());
		return "nuevocliente";
	}
	
	@PostMapping("/cliente/guardar")
	public ModelAndView postGuardarCliente(@ModelAttribute("cliente") Cliente cliente)
	{
		clienteService.addCliente(cliente);
		ModelAndView modelView = new ModelAndView("clientes");
		modelView.addObject("clientes", clienteService.getListaClientes());
		return modelView;
	}	
	
	@GetMapping("/cliente/listado")
	public ModelAndView getListadoClientesPage() {
		ModelAndView modelView = new ModelAndView("clientes");
		modelView.addObject("clientes", clienteService.getListaClientes());
		return modelView;
	}
		
}
