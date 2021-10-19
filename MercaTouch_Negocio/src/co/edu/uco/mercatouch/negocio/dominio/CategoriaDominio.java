package co.edu.uco.mercatouch.negocio.dominio;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class CategoriaDominio 
{
	int codigo;
	String nombre;
	String descripcion;
	
	private CategoriaDominio(int codigo, String nombre, String descripcion) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
	}
	
	public static CategoriaDominio crear(int codigo, String nombre, String descripcion)
	{
		return new CategoriaDominio(codigo, nombre, descripcion);
	}
	
	public static CategoriaDominio crear()
	{
		return new CategoriaDominio(0, UtilTexto.BLANCO, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public CategoriaDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public CategoriaDominio setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public CategoriaDominio setDescripcion(String descripcion) 
	{
		this.descripcion = UtilTexto.aplicarTrim(descripcion);
		return this;
	}
}