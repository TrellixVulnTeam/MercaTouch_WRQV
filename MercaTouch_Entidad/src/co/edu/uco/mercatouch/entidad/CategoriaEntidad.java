package co.edu.uco.mercatouch.entidad;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class CategoriaEntidad 
{
	int codigo;
	String nombre;
	String descripcion;
	
	private CategoriaEntidad(int codigo, String nombre, String descripcion) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
	}
	
	public static CategoriaEntidad crear(int codigo, String nombre, String descripcion)
	{
		return new CategoriaEntidad(codigo, nombre, descripcion);
	}
	
	public static CategoriaEntidad crear()
	{
		return new CategoriaEntidad(0, UtilTexto.BLANCO, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public CategoriaEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public CategoriaEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public CategoriaEntidad setDescripcion(String descripcion) 
	{
		this.descripcion = UtilTexto.aplicarTrim(descripcion);
		return this;
	}
}