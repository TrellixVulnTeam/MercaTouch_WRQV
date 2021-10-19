package co.edu.uco.mercatouch.dto;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class ProductoDTO 
{
	int codigo;
	String nombre;
	String descripcion;
	double precio;
	CategoriaDTO categoria;
	
	private ProductoDTO(int codigo, String nombre, String descripcion, double precio, CategoriaDTO categoria) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setCategoria(categoria);
	}
	
	public static ProductoDTO crear(int codigo, String nombre, String descripcion, double precio, CategoriaDTO categoria)
	{
		return new ProductoDTO(codigo, nombre, descripcion, precio, categoria);
	}
	
	public static ProductoDTO crear()
	{
		return new ProductoDTO(0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, CategoriaDTO.crear());
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

	public double getPrecio() 
	{
		return precio;
	}

	public ProductoDTO setPrecio(double precio) 
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
}