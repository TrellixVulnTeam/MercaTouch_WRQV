package co.edu.uco.mercatouch.dto;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class TiendaDTO 
{
	int codigo;
	String nombre;
	String direccion;
	String ciudad;
	String departamento;
	long telefono;
	int calificacion;
	
	public TiendaDTO()
	{
		
	}
	
	private TiendaDTO(int codigo, String nombre, String direccion, String ciudad, String departamento, long telefono, int calificacion) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDireccion(direccion);
		setCiudad(ciudad);
		setDepartamento(departamento);
		setTelefono(telefono);
		setCalificacion(calificacion);
	}
	
	public static TiendaDTO crear(int codigo, String nombre, String direccion, String ciudad, String departamento, long telefono, int calificacion)
	{
		return new TiendaDTO(codigo, nombre, direccion, ciudad, departamento, telefono, calificacion);
	}
	
	public static TiendaDTO crear()
	{
		return new TiendaDTO(0, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public TiendaDTO setCodigo(int codigo)
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public TiendaDTO setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getDireccion() 
	{
		return direccion;
	}

	public TiendaDTO setDireccion(String direccion) 
	{
		this.direccion = UtilTexto.aplicarTrim(direccion);
		return this;
	}

	public String getCiudad() 
	{
		return ciudad;
	}

	public TiendaDTO setCiudad(String ciudad) 
	{
		this.ciudad = UtilTexto.aplicarTrim(ciudad);
		return this;
	}

	public String getDepartamento() 
	{
		return departamento;
	}

	public TiendaDTO setDepartamento(String departamento) 
	{
		this.departamento = UtilTexto.aplicarTrim(departamento);
		return this;
	}

	public long getTelefono() 
	{
		return telefono;
	}

	public TiendaDTO setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}

	public int getCalificacion() 
	{
		return calificacion;
	}

	public TiendaDTO setCalificacion(int calificacion) 
	{
		this.calificacion = calificacion;
		return this;
	}
}
