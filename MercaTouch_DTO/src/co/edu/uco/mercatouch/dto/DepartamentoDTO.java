package co.edu.uco.mercatouch.dto;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class DepartamentoDTO 
{
	private int codigo;
	private String nombre;
	
	public DepartamentoDTO()
	{
		
	}
	
	private DepartamentoDTO(int codigo, String nombre) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	public static DepartamentoDTO crear(int codigo, String nombre)
	{
		return new DepartamentoDTO(codigo, nombre);
	}
	
	public static DepartamentoDTO crear()
	{
		return new DepartamentoDTO(0, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public DepartamentoDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public DepartamentoDTO setNombre(String nombre) 
	{
		this.nombre = nombre;
		return this;
	}
}