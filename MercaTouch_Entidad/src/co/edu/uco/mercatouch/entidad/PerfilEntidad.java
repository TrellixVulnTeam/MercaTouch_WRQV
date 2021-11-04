package co.edu.uco.mercatouch.entidad;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class PerfilEntidad 
{
	private int codigo;
	private String nombre;
	
	private PerfilEntidad(int codigo, String nombre) 
	{
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static PerfilEntidad crear(int codigo, String nombre)
	{
		return new PerfilEntidad(codigo, nombre);
	}
	
	public static PerfilEntidad crear()
	{
		return new PerfilEntidad(0, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PerfilEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public PerfilEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}
}