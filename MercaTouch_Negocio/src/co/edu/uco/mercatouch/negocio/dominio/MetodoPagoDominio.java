package co.edu.uco.mercatouch.negocio.dominio;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class MetodoPagoDominio 
{
	int codigo;
	String nombre;
	boolean incluyeDomicilio;
	
	private MetodoPagoDominio(int codigo, String nombre, boolean incluyeDomicilio) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setIncluyeDomicilio(incluyeDomicilio);
	}
	
	public static MetodoPagoDominio crear(int codigo, String nombre, boolean incluyeDomicilio)
	{
		return new MetodoPagoDominio(codigo, nombre, incluyeDomicilio);
	}
	
	public static MetodoPagoDominio crear()
	{
		return new MetodoPagoDominio(0, UtilTexto.BLANCO, false);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public MetodoPagoDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public MetodoPagoDominio setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public boolean isIncluyeDomicilio() 
	{
		return incluyeDomicilio;
	}

	public MetodoPagoDominio setIncluyeDomicilio(boolean incluyeDomicilio) 
	{
		this.incluyeDomicilio = incluyeDomicilio;
		return this;
	}
}