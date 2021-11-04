package co.edu.uco.mercatouch.dto;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class CiudadDTO 
{
	private int codigo;
	private String nombre;
	private DepartamentoDTO departamento;
	
	public CiudadDTO()
	{
		
	}
	
	private CiudadDTO(int codigo, String nombre, DepartamentoDTO departamento) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
		this.departamento = departamento;
	}
	
	public static CiudadDTO crear(int codigo, String nombre, DepartamentoDTO departamento)
	{
		return new CiudadDTO(codigo, nombre, departamento);
	}
	
	public static CiudadDTO crear()
	{
		return new CiudadDTO(0, UtilTexto.BLANCO, DepartamentoDTO.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public CiudadDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public CiudadDTO setNombre(String nombre) 
	{
		this.nombre = nombre;
		return this;
	}

	public DepartamentoDTO getDepartamento() 
	{
		return departamento;
	}

	public CiudadDTO setDepartamento(DepartamentoDTO departamento) 
	{
		this.departamento = departamento;
		return this;
	}
}
