package co.edu.uco.mercatouch.dto;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class MetodoPagoDTO 
{
	int codigo;
	String nombre;
	
	public MetodoPagoDTO()
	{
		
	}
	
	private MetodoPagoDTO(int codigo, String nombre) 
	{
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static MetodoPagoDTO crear(int codigo, String nombre)
	{
		return new MetodoPagoDTO(codigo, nombre);
	}
	
	public static MetodoPagoDTO crear()
	{
		return new MetodoPagoDTO(0, UtilTexto.BLANCO);
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
}