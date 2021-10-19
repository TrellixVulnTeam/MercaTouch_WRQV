package co.edu.uco.mercatouch.negocio.dominio;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class ProductoDominio 
{
	int codigo;
	String nombre;
	String descripcion;
	double precio;
	CategoriaDominio categoria;
	
	private ProductoDominio(int codigo, String nombre, String descripcion, double precio, CategoriaDominio categoria) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setCategoria(categoria);
	}
	
	public static ProductoDominio crear(int codigo, String nombre, String descripcion, double precio, CategoriaDominio categoria)
	{
		return new ProductoDominio(codigo, nombre, descripcion, precio, categoria);
	}
	
	public static ProductoDominio crear()
	{
		return new ProductoDominio(0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, CategoriaDominio.crear());
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

	public double getPrecio() 
	{
		return precio;
	}

	public ProductoDominio setPrecio(double precio) 
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
}