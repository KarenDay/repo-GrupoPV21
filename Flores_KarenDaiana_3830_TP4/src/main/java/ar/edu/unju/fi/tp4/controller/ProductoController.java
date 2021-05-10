package ar.edu.unju.fi.tp4.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.IProductoService;
/**
 * 
 * @author Karen Flores
 *
 */
@Controller
public class ProductoController {
	//coloqué el Log en el controller para ver el paso a paso	
	private static final Log LOGGER = LogFactory.getLog(ProductoController.class);
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/producto/nuevo")
	public String getNuevoPage(Model model) {
		LOGGER.info("CONTROLLER: ProductoController with /producto get method");
		LOGGER.info("METHOD: getNuevoPage(Model model)");
		LOGGER.info("RESULT: visualiza la pagina nuevoproducto.html");
		model.addAttribute(productoService.nuevoProducto());
		return "nuevoproducto";
	}
	
	@PostMapping("/producto/guardar")
	public String postGuardarNuevoProductoNewPage(@ModelAttribute("productoNuevo") Producto productoNuevo) {
		LOGGER.info("CONTROLLER: ProductoController with /producto/guardar with post method");
		LOGGER.info("METHOD: postGuardarNuevoProductoNewPage()");
		LOGGER.info("RESULT: guarda los datos en la lista de productos cargados en la pagina nuevo.html y muestra un msj en la pagina resultado.html");
		productoService.agregarProducto(productoNuevo);
		
		return "productos";
	}
	
	@GetMapping("/producto/ultimo")
	public ModelAndView getMostrarUltimoProductoPage() {
		LOGGER.info("CONTROLLER: ProductoController with /producto/ultimo get method");
		LOGGER.info("METHOD: getMostrarUltimoProducto()");
		LOGGER.info("RESULT: muestra los datos del ultimo producto cargado en la lista de productos");
		ModelAndView modelAndView = new ModelAndView("ultimoproducto");
		modelAndView.addObject("ultimoProducto", productoService.devolverUltimoProducto());
		return modelAndView;
	}
	
	@GetMapping("/producto/listado")
	public ModelAndView getListProductoPage() {
		
		ModelAndView modelAndView = new ModelAndView("productos");
		modelAndView.addObject("productos", productoService.getListaProductos());
		return modelAndView;
	}
	
	
}
