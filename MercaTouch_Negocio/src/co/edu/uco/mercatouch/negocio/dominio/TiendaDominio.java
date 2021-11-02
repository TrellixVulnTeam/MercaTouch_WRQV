package co.edu.uco.mercatouch.negocio.dominio;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class TiendaDominio 
{
	int codigo;
	String nombre;
	String direccion;
	String ciudad;
	String departamento;
	long telefono;
	int calificacion;
	
	private TiendaDominio(int codigo, String nombre, String direccion, String ciudad, String departamento, long telefono, int calificacion) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDireccion(direccion);
		setCiudad(ciudad);
		setDepartamento(departamento);
		setTelefono(telefono);
		setCalificacion(calificacion);
	}
	
	public static TiendaDominio crear(int codigo, String nombre, String direccion, String ciudad, String departamento, long telefono, int calificacion)
	{
		return new TiendaDominio(codigo, nombre, direccion, ciudad, departamento, telefono, calificacion);
	}
	
	public static TiendaDominio crear()
	{
		return new TiendaDominio(0, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public TiendaDominio setCodigo(int codigo)
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public TiendaDominio setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getDireccion() 
	{
		return direccion;
	}

	public TiendaDominio setDireccion(String direccion) 
	{
		this.direccion = UtilTexto.aplicarTrim(direccion);
		return this;
	}

	public String getCiudad() 
	{
		return ciudad;
	}

	public TiendaDominio setCiudad(String ciudad) 
	{
		this.ciudad = UtilTexto.aplicarTrim(ciudad);
		return this;
	}

	public String getDepartamento() 
	{
		return departamento;
	}

	public TiendaDominio setDepartamento(String departamento) 
	{
		this.departamento = UtilTexto.aplicarTrim(departamento);
		return this;
	}

	public long getTelefono() 
	{
		return telefono;
	}

	public TiendaDominio setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}

	public int getCalificacion() 
	{
		return calificacion;
	}

	public TiendaDominio setCalificacion(int calificacion) 
	{
		this.calificacion = calificacion;
		return this;
	}
}
