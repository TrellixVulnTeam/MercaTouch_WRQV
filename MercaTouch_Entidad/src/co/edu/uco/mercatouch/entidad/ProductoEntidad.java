package co.edu.uco.mercatouch.entidad;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class ProductoEntidad 
{
	private int codigo;
	private String nombre;
	private String descripcion;
	private PrecioEntidad precio;
	private CategoriaEntidad categoria;
	private TiendaProductoEntidad tiendaProducto;
	
	private ProductoEntidad(int codigo, String nombre, String descripcion, PrecioEntidad precio, CategoriaEntidad categoria, TiendaProductoEntidad tiendaProducto) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setCategoria(categoria);
		setTiendaProducto(tiendaProducto);
	}
	
	public static ProductoEntidad crear(int codigo, String nombre, String descripcion, PrecioEntidad precio, CategoriaEntidad categoria, TiendaProductoEntidad tiendaProducto)
	{
		return new ProductoEntidad(codigo, nombre, descripcion, precio, categoria, tiendaProducto);
	}
	
	public static ProductoEntidad crear()
	{
		return new ProductoEntidad(0, UtilTexto.BLANCO, UtilTexto.BLANCO, PrecioEntidad.crear(), CategoriaEntidad.crear(), TiendaProductoEntidad.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public ProductoEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public ProductoEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public ProductoEntidad setDescripcion(String descripcion) 
	{
		this.descripcion = UtilTexto.aplicarTrim(descripcion);
		return this;
	}

	public PrecioEntidad getPrecio() 
	{
		return precio;
	}

	public ProductoEntidad setPrecio(PrecioEntidad precio) 
	{
		this.precio = precio;
		return this;
	}

	public CategoriaEntidad getCategoria() 
	{
		return categoria;
	}

	public ProductoEntidad setCategoria(CategoriaEntidad categoria) 
	{
		this.categoria = categoria;
		return this;
	}

	public TiendaProductoEntidad getTiendaProducto() 
	{
		return tiendaProducto;
	}

	public ProductoEntidad setTiendaProducto(TiendaProductoEntidad tiendaProducto) 
	{
		this.tiendaProducto = tiendaProducto;
		return this;
	}
}