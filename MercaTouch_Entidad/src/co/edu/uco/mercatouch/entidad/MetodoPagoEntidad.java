package co.edu.uco.mercatouch.entidad;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class MetodoPagoEntidad 
{
	int codigo;
	String nombre;
	
	public MetodoPagoEntidad()
	{
		
	}
	
	private MetodoPagoEntidad(int codigo, String nombre) 
	{
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static MetodoPagoEntidad crear(int codigo, String nombre)
	{
		return new MetodoPagoEntidad(codigo, nombre);
	}
	
	public static MetodoPagoEntidad crear()
	{
		return new MetodoPagoEntidad(0, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public MetodoPagoEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public MetodoPagoEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}
}