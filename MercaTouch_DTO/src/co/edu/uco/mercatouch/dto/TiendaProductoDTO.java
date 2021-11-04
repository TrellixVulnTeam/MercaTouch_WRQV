package co.edu.uco.mercatouch.dto;

import java.util.ArrayList;
import java.util.List;

public class TiendaProductoDTO 
{
	private int codigo;
	private TiendaDTO tienda;
	private List<ProductoDTO> productos;
	
	public TiendaProductoDTO()
	{
		
	}
	
	private TiendaProductoDTO(int codigo, TiendaDTO tienda, List<ProductoDTO> productos) 
	{
		setCodigo(codigo);
		setTienda(tienda);
		setProductos(productos);
	}
	
	public static TiendaProductoDTO crear(int codigo, TiendaDTO tienda, List<ProductoDTO> productos)
	{
		return new TiendaProductoDTO(codigo, tienda, productos);
	}
	
	public static TiendaProductoDTO crear()
	{
		return new TiendaProductoDTO(0, TiendaDTO.crear(), new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public TiendaProductoDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public TiendaDTO getTienda() 
	{
		return tienda;
	}

	public TiendaProductoDTO setTienda(TiendaDTO tienda) 
	{
		this.tienda = tienda;
		return this;
	}

	public List<ProductoDTO> getProductos() 
	{
		return productos;
	}

	public TiendaProductoDTO setProductos(List<ProductoDTO> productos) 
	{
		this.productos = productos;
		return this;
	}
}