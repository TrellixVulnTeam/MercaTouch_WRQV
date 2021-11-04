package co.edu.uco.mercatouch.entidad;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class CiudadEntidad 
{
	private int codigo;
	private String nombre;
	private DepartamentoEntidad departamento;
	
	private CiudadEntidad(int codigo, String nombre, DepartamentoEntidad departamento) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
		this.departamento = departamento;
	}
	
	public static CiudadEntidad crear(int codigo, String nombre, DepartamentoEntidad departamento)
	{
		return new CiudadEntidad(codigo, nombre, departamento);
	}
	
	public static CiudadEntidad crear()
	{
		return new CiudadEntidad(0, UtilTexto.BLANCO, DepartamentoEntidad.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public CiudadEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public CiudadEntidad setNombre(String nombre) 
	{
		this.nombre = nombre;
		return this;
	}

	public DepartamentoEntidad getDepartamento() 
	{
		return departamento;
	}

	public CiudadEntidad setDepartamento(DepartamentoEntidad departamento) 
	{
		this.departamento = departamento;
		return this;
	}
}
