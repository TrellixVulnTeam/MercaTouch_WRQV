package co.edu.uco.mercatouch.dto;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class ProductoDTO 
{
	private int codigo;
	private String nombre;
	private String descripcion;
	private PrecioDTO precio;
	private CategoriaDTO categoria;
	private TiendaProductoDTO tiendaProducto;
	
	public ProductoDTO()
	{
		
	}
	
	private ProductoDTO(int codigo, String nombre, String descripcion, PrecioDTO precio, CategoriaDTO categoria, TiendaProductoDTO tiendaProducto) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setCategoria(categoria);
		setTiendaProducto(tiendaProducto);
	}
	
	public static ProductoDTO crear(int codigo, String nombre, String descripcion, PrecioDTO precio, CategoriaDTO categoria, TiendaProductoDTO tiendaProducto)
	{
		return new ProductoDTO(codigo, nombre, descripcion, precio, categoria, tiendaProducto);
	}
	
	public static ProductoDTO crear()
	{
		return new ProductoDTO(0, UtilTexto.BLANCO, UtilTexto.BLANCO, PrecioDTO.crear(), CategoriaDTO.crear(), TiendaProductoDTO.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public ProductoDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public ProductoDTO setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public ProductoDTO setDescripcion(String descripcion) 
	{
		this.descripcion = UtilTexto.aplicarTrim(descripcion);
		return this;
	}

	public PrecioDTO getPrecio() 
	{
		return precio;
	}

	public ProductoDTO setPrecio(PrecioDTO precio) 
	{
		this.precio = precio;
		return this;
	}

	public CategoriaDTO getCategoria() 
	{
		return categoria;
	}

	public ProductoDTO setCategoria(CategoriaDTO categoria) 
	{
		this.categoria = categoria;
		return this;
	}

	public TiendaProductoDTO getTiendaProducto() 
	{
		return tiendaProducto;
	}

	public ProductoDTO setTiendaProducto(TiendaProductoDTO tiendaProducto) 
	{
		this.tiendaProducto = tiendaProducto;
		return this;
	}
}