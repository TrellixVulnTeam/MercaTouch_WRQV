package co.edu.uco.mercatouch.negocio.dominio;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class DepartamentoDominio 
{
	private int codigo;
	private String nombre;
	
	private DepartamentoDominio(int codigo, String nombre) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	public static DepartamentoDominio crear(int codigo, String nombre)
	{
		return new DepartamentoDominio(codigo, nombre);
	}
	
	public static DepartamentoDominio crear()
	{
		return new DepartamentoDominio(0, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public DepartamentoDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public DepartamentoDominio setNombre(String nombre) 
	{
		this.nombre = nombre;
		return this;
	}
}