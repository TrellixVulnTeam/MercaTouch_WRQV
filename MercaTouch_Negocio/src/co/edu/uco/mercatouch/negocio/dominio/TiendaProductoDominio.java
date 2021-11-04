package co.edu.uco.mercatouch.negocio.dominio;

import java.util.ArrayList;
import java.util.List;

public class TiendaProductoDominio 
{
	private int codigo;
	private TiendaDominio tienda;
	private List<ProductoDominio> productos;
	
	private TiendaProductoDominio(int codigo, TiendaDominio tienda, List<ProductoDominio> productos) 
	{
		setCodigo(codigo);
		setTienda(tienda);
		setProductos(productos);
	}
	
	public static TiendaProductoDominio crear(int codigo, TiendaDominio tienda, List<ProductoDominio> productos)
	{
		return new TiendaProductoDominio(codigo, tienda, productos);
	}
	
	public static TiendaProductoDominio crear()
	{
		return new TiendaProductoDominio(0, TiendaDominio.crear(), new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public TiendaProductoDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public TiendaDominio getTienda() 
	{
		return tienda;
	}

	public TiendaProductoDominio setTienda(TiendaDominio tienda) 
	{
		this.tienda = tienda;
		return this;
	}

	public List<ProductoDominio> getProductos() 
	{
		return productos;
	}

	public TiendaProductoDominio setProductos(List<ProductoDominio> productos) 
	{
		this.productos = productos;
		return this;
	}
}