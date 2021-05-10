package ar.edu.unju.fi.tp4.service;


import java.util.List;

import ar.edu.unju.fi.tp4.model.Producto;
/**
 * 
 * @author Karen Flores
 *
 */
public interface IProductoService {

	Producto nuevoProducto();
	
	void agregarProducto(Producto producto);
	
	Producto devolverUltimoProducto();
	
	List<Producto> getListaProductos();
	
	void generarTablaProductos();
}
