package co.edu.uco.mercatouch.entidad;

import java.util.ArrayList;
import java.util.List;

public class TiendaProductoEntidad 
{
	private int codigo;
	private TiendaEntidad tienda;
	private List<ProductoEntidad> productos;
	
	private TiendaProductoEntidad(int codigo, TiendaEntidad tienda, List<ProductoEntidad> productos) 
	{
		setCodigo(codigo);
		setTienda(tienda);
		setProductos(productos);
	}
	
	public static TiendaProductoEntidad crear(int codigo, TiendaEntidad tienda, List<ProductoEntidad> productos)
	{
		return new TiendaProductoEntidad(codigo, tienda, productos);
	}
	
	public static TiendaProductoEntidad crear()
	{
		return new TiendaProductoEntidad(0, TiendaEntidad.crear(), new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public TiendaProductoEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public TiendaEntidad getTienda() 
	{
		return tienda;
	}

	public TiendaProductoEntidad setTienda(TiendaEntidad tienda) 
	{
		this.tienda = tienda;
		return this;
	}

	public List<ProductoEntidad> getProductos() 
	{
		return productos;
	}

	public TiendaProductoEntidad setProductos(List<ProductoEntidad> productos) 
	{
		this.productos = productos;
		return this;
	}
}