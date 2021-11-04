package co.edu.uco.mercatouch.negocio.dominio;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class MetodoPagoDominio 
{
	int codigo;
	String nombre;
	
	private MetodoPagoDominio(int codigo, String nombre) 
	{
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static MetodoPagoDominio crear(int codigo, String nombre)
	{
		return new MetodoPagoDominio(codigo, nombre);
	}
	
	public static MetodoPagoDominio crear()
	{
		return new MetodoPagoDominio(0, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public MetodoPagoDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public MetodoPagoDominio setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}
}