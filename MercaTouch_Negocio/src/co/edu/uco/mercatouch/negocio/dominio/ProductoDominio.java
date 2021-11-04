package co.edu.uco.mercatouch.negocio.dominio;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class ProductoDominio 
{
	private int codigo;
	private String nombre;
	private String descripcion;
	private PrecioDominio precio;
	private CategoriaDominio categoria;
	private TiendaProductoDominio tiendaProducto;
	
	private ProductoDominio(int codigo, String nombre, String descripcion, PrecioDominio precio, CategoriaDominio categoria, TiendaProductoDominio tiendaProducto) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setCategoria(categoria);
		setTiendaProducto(tiendaProducto);
	}
	
	public static ProductoDominio crear(int codigo, String nombre, String descripcion, PrecioDominio precio, CategoriaDominio categoria, TiendaProductoDominio tiendaProducto)
	{
		return new ProductoDominio(codigo, nombre, descripcion, precio, categoria, tiendaProducto);
	}
	
	public static ProductoDominio crear()
	{
		return new ProductoDominio(0, UtilTexto.BLANCO, UtilTexto.BLANCO, PrecioDominio.crear(), CategoriaDominio.crear(), TiendaProductoDominio.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public ProductoDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public ProductoDominio setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public ProductoDominio setDescripcion(String descripcion) 
	{
		this.descripcion = UtilTexto.aplicarTrim(descripcion);
		return this;
	}

	public PrecioDominio getPrecio() 
	{
		return precio;
	}

	public ProductoDominio setPrecio(PrecioDominio precio) 
	{
		this.precio = precio;
		return this;
	}

	public CategoriaDominio getCategoria() 
	{
		return categoria;
	}

	public ProductoDominio setCategoria(CategoriaDominio categoria) 
	{
		this.categoria = categoria;
		return this;
	}

	public TiendaProductoDominio getTiendaProducto() 
	{
		return tiendaProducto;
	}

	public ProductoDominio setTiendaProducto(TiendaProductoDominio tiendaProducto) 
	{
		this.tiendaProducto = tiendaProducto;
		return this;
	}
}