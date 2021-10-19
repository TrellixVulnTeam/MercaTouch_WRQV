package co.edu.uco.mercatouch.dto;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class CategoriaDTO 
{
	int codigo;
	String nombre;
	String descripcion;
	
	private CategoriaDTO(int codigo, String nombre, String descripcion) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
	}
	
	public static CategoriaDTO crear(int codigo, String nombre, String descripcion)
	{
		return new CategoriaDTO(codigo, nombre, descripcion);
	}
	
	public static CategoriaDTO crear()
	{
		return new CategoriaDTO(0, UtilTexto.BLANCO, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public CategoriaDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public CategoriaDTO setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public CategoriaDTO setDescripcion(String descripcion) 
	{
		this.descripcion = UtilTexto.aplicarTrim(descripcion);
		return this;
	}
}