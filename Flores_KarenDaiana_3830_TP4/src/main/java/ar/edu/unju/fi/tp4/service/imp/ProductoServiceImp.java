package ar.edu.unju.fi.tp4.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.IProductoService;
import ar.edu.unju.fi.tp4.util.TablaProductos;
/**
 * 
 * @author Karen Flores
 *
 */
@Service("productoService")
public class ProductoServiceImp implements IProductoService {
	private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);
	
	@Autowired
	@Qualifier("nuevoProducto")
	private Producto producto;
	
	private List<Producto> productos;
	
	@Override
	public void agregarProducto(Producto producto) {
		LOGGER.info("SERVICE: ProductoServiceImp");
		LOGGER.info("METHOD: AgregarProducto() con objeto del tipo Producto como parametro");
		LOGGER.info("RESULT: agrega un producto a la lista de productos");
		productos.add(producto);
		LOGGER.info("Producto con codigo:"+productos.get(productos.size()-1).getCodigo()+" agregado exitosamente a la lista");
	}

	@Override
	public Producto devolverUltimoProducto() {
		LOGGER.info("SERVICE: ProductoServiceImp");
		LOGGER.info("METHOD: devolverUltimoProducto() ");
		LOGGER.info("RESULT: devuelve el ultimo producto que se encuentra en la lista de productos");
		if(productos==null)
			generarTablaProductos();
		LOGGER.info("Cantidad de productos en la lista:" +productos.size());
		return productos.get(productos.size()-1);
	}

	@Override
	public Producto nuevoProducto() {
		LOGGER.info("SERVICE: ProductoServiceImp");
		LOGGER.info("METHOD: nuevoProducto");
		return producto;
	}

	@Override
	public List<Producto> getListaProductos() {
		if (productos==null)
			generarTablaProductos();
		return productos;
	}

	@Override
	public void generarTablaProductos() {
		
		productos = TablaProductos.listaProductos;
		Producto producto = new Producto(10,"Pasta Dental",250d,"Colgate",100);
		productos.add(producto);
	}

}
