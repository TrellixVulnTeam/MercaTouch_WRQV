package co.edu.uco.mercatouch.dto;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class PerfilDTO 
{
	private int codigo;
	private String nombre;
	
	public PerfilDTO()
	{
		
	}
	
	private PerfilDTO(int codigo, String nombre) 
	{
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static PerfilDTO crear(int codigo, String nombre)
	{
		return new PerfilDTO(codigo, nombre);
	}
	
	public static PerfilDTO crear()
	{
		return new PerfilDTO(0, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PerfilDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public PerfilDTO setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}
}