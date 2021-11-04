package co.edu.uco.mercatouch.entidad;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class DepartamentoEntidad 
{
	private int codigo;
	private String nombre;
	
	private DepartamentoEntidad(int codigo, String nombre) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	public static DepartamentoEntidad crear(int codigo, String nombre)
	{
		return new DepartamentoEntidad(codigo, nombre);
	}
	
	public static DepartamentoEntidad crear()
	{
		return new DepartamentoEntidad(0, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public DepartamentoEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public DepartamentoEntidad setNombre(String nombre) 
	{
		this.nombre = nombre;
		return this;
	}
}