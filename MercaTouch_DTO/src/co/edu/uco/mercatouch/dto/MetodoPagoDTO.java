package co.edu.uco.mercatouch.dto;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class MetodoPagoDTO 
{
	int codigo;
	String nombre;
	boolean incluyeDomicilio;
	
	private MetodoPagoDTO(int codigo, String nombre, boolean incluyeDomicilio) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setIncluyeDomicilio(incluyeDomicilio);
	}
	
	public static MetodoPagoDTO crear(int codigo, String nombre, boolean incluyeDomicilio)
	{
		return new MetodoPagoDTO(codigo, nombre, incluyeDomicilio);
	}
	
	public static MetodoPagoDTO crear()
	{
		return new MetodoPagoDTO(0, UtilTexto.BLANCO, false);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public MetodoPagoDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public MetodoPagoDTO setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public boolean isIncluyeDomicilio() 
	{
		return incluyeDomicilio;
	}

	public MetodoPagoDTO setIncluyeDomicilio(boolean incluyeDomicilio) 
	{
		this.incluyeDomicilio = incluyeDomicilio;
		return this;
	}
}