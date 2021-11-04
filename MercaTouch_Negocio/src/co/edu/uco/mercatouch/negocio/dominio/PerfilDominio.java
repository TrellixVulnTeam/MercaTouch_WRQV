package co.edu.uco.mercatouch.negocio.dominio;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class PerfilDominio 
{
	private int codigo;
	private String nombre;
	
	private PerfilDominio(int codigo, String nombre) 
	{
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static PerfilDominio crear(int codigo, String nombre)
	{
		return new PerfilDominio(codigo, nombre);
	}
	
	public static PerfilDominio crear()
	{
		return new PerfilDominio(0, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PerfilDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public PerfilDominio setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}
}