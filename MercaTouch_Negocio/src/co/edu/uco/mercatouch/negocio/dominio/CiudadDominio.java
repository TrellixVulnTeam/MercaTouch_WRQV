package co.edu.uco.mercatouch.negocio.dominio;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class CiudadDominio 
{
	private int codigo;
	private String nombre;
	private DepartamentoDominio departamento;
	
	private CiudadDominio(int codigo, String nombre, DepartamentoDominio departamento) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
		this.departamento = departamento;
	}
	
	public static CiudadDominio crear(int codigo, String nombre, DepartamentoDominio departamento)
	{
		return new CiudadDominio(codigo, nombre, departamento);
	}
	
	public static CiudadDominio crear()
	{
		return new CiudadDominio(0, UtilTexto.BLANCO, DepartamentoDominio.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public CiudadDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public CiudadDominio setNombre(String nombre) 
	{
		this.nombre = nombre;
		return this;
	}

	public DepartamentoDominio getDepartamento() 
	{
		return departamento;
	}

	public CiudadDominio setDepartamento(DepartamentoDominio departamento) 
	{
		this.departamento = departamento;
		return this;
	}
}
